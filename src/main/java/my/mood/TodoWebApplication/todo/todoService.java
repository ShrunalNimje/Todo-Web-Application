package my.mood.TodoWebApplication.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class todoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 0;
	static {
		todos.add(new Todo(++todoCount, "Adam", "Learn Spring", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount, "Adam", "Learn Spring Boot", LocalDate.now().plusYears((long) 1.5), false));
		todos.add(new Todo(++todoCount, "Adam", "Learn Docker", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todoCount, "Adam", "Learn JPA", LocalDate.now().plusYears((long) 2.5), false));
		todos.add(new Todo(++todoCount, "Adam", "Learn Kubernetes", LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> getByUsername(String username) {
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todoCount, username, description, targetDate, done);
		todos.add(todo);
	}
	
	public void deleteTodo(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate );
	}
	
	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	public void updateTodo(@Valid Todo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
	}
}
