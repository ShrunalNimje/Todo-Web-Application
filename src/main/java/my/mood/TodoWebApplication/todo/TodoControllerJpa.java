package my.mood.TodoWebApplication.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

	@Autowired
	private TodoService todoService;
	
	@Autowired
	private TodoRepository todoRepository;
	
	public TodoControllerJpa(TodoService todoService, TodoRepository todoRepository) {
		this.todoService = todoService;
		this.todoRepository = todoRepository;
	}
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInName(model);
		List<Todo> todos = todoRepository.getByUsername(username);
		
		model.addAttribute("todos", todos);
		return "allTodos";
	}

	
	@RequestMapping(value = "add-todos", method = RequestMethod.GET)
	public String addNewTodos(ModelMap model) {
		
		String username = getLoggedInName(model);
		Todo todo = new Todo(0, username, "", LocalDate.now(), false);
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value = "add-todos", method = RequestMethod.POST)
	public String returnNewTodos(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}
		
		String username = getLoggedInName(model);
		todo.setUsername(username);
		
		// todoService.addTodo(todo.getUsername(), todo.getDescription(), todo.getTargetDate(), false);
		
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		// todoService.deleteTodo(id);
		
		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		// Todo todo = todoService.findById(id);
		
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(@Valid Todo todo, ModelMap model, BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}
		
		String username = getLoggedInName(model);
		// todoService.updateTodo(todo);
		
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedInName(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
