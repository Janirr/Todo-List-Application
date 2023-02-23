package pl.poznan.put.demo.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;


@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
    private final TodoRepository todoRepository;
    public TodoControllerJpa(TodoRepository todoRepository) {
        super();
        this.todoRepository = todoRepository;
    }

    @RequestMapping("list-todos")
    public String showTodos(ModelMap model) {
        String username = (String) model.get("name");
        List<Todo> todos = todoRepository.findByUsername(username);
        model.addAttribute("todos", todos);
        return "list-todos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        Todo todo = new Todo(0,
                getLoggedInUsername(model),
                "",
                LocalDate.now().plusYears(1),
                false);
        model.put("todo",todo);
        return "todo";
    }


    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodoPage(ModelMap model, @Valid Todo todo,
                                 BindingResult result) {
        if (result.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id){
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model){
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo",todo);
        return "todo";
    }
    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(@Valid Todo todo, BindingResult result, ModelMap model){
        if (result.hasErrors()){
            return "todo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }

    private static String getLoggedInUsername(ModelMap model) {
        return (String) model.get("name");
    }

}
