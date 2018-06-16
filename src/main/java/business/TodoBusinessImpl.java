package business;

import data.api.TodoService;

import java.util.ArrayList;
import java.util.List;

// this is the SUT
// We depend on TodoService

public class TodoBusinessImpl {
    private TodoService todoService;

    TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<String>();
        List<String> todos = todoService.retrieveTodos(user);
        for (String todo : todos) {
            if(todo.contains("Spring")){
                filteredTodos.add(todo);
            }
        }

        return filteredTodos;
    }

    public void deleteTodosNotRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<String>();
        List<String> todos = todoService.retrieveTodos(user);
        for (String todo : todos) {
            if(!todo.contains("Spring")){
                todoService.deleteTodo(todo);
            }
        }
    }
}
