package business;

import data.api.TodoService;
import data.api.TodoServiceStub;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {
    // Dynamic condition

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() {

        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos =Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD() {

        // Given
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos =Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        // Then
        assertThat(filteredTodos.size(), is(2));
    }

    @Test
    public void testDeleteTodosRelatedToSpring_usingBDD() {

        // Given
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos =Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        // Then
        verify(todoServiceMock).deleteTodo("Learn to Dance");
        verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");

        // use verify when there are no side effects i.e when there are no return values
    }

    @Test
    public void testDeleteTodosRelatedToSpring_usingBDD_argumentCapture() {

        // Declare an Argument Captor
        // Define Argument captor on specific method call
        // Capture the argument
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        // Given
        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos =Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");

        // Then
        verify(todoServiceMock).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
    }
}