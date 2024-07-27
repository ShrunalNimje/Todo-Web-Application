package my.mood.TodoWebApplication.todo;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public class Todo {

	private int id;
	private String username;
	
	@Size(min = 10, message = "Please fill at least of 10 characters")
	private String description;
	private LocalDate targetDate;
	private boolean done;
	
	public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
		this.description = description;
		this.id = id;
		this.done = done;
		this.targetDate = targetDate;
		this.username = username;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean getDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", done=" + done + "]";
	}
	
}
