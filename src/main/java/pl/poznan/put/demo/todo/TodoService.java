package pl.poznan.put.demo.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static final List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;
    static {
        todos.add(new Todo(++todosCount, "admin", "Learn Spring MVC 1", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "admin", "Learn Struts 1", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "user", "Learn Hibernate 1", LocalDate.now().plusYears(1), false));
    }
    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate
                = todo -> todo.getUsername().equals(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description,
                        LocalDate targetDate, boolean isDone){
        Todo todo = new Todo(++todosCount,username,description,targetDate,isDone);
        todos.add(todo);
    }

    public void removeTodo(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
         todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(@Valid Todo todo) {
        removeTodo(todo.getId());
        todos.add(todo);
    }
}
