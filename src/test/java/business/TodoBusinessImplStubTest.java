package business;

import data.api.TodoService;
import data.api.TodoServiceStub;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TodoBusinessImplStubTest {
    // Dynamic condition

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAStub() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }
}