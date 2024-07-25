package my.mood.TodoWebApplication.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	private todoService todoService;
	
	public TodoController(todoService todoService) {
		this.todoService = todoService;
	}
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.getByUsername((String)model.get("name"));
		
		model.addAttribute("todos", todos);
		return "allTodos";
	}
	
	@RequestMapping(value = "add-todos", method = RequestMethod.GET)
	public String addNewTods(ModelMap model) {
		
		String username = (String)model.get("name");
		Todo todo = new Todo(0, username, "Default", LocalDate.now(), false);
		model.put("todo", todo);
		return "addTodo";
	}
	
	@RequestMapping(value = "add-todos", method = RequestMethod.POST)
	public String returnNewTods(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "addTodo";
		}
		String username = (String)model.get("name");
		todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
		


		return "redirect:list-todos";
	}
}
