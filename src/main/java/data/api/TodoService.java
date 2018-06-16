package data.api;

import java.util.List;

// Create TodoService stub
// Test TodoBusinessImpl using TodoServiceStub
public interface TodoService {
    public List<String> retrieveTodos(String user);
    public void deleteTodo(String todo);
}
