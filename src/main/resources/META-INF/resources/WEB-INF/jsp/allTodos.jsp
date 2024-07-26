<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
	<head>
		<link href = "webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel = "stylesheet">
		
		<title> 
			TODOS LIST
		</title>	
	</head>
	
	<body>
		<div class = "container">
			<h1>WELCOME ${name}</h1>
			
			<hr>
			<h1>your todo's</h1>
		
			<table class = "table">
				<thead>
					<tr>
						<th>id</th>
						<th>description</th>
						<th>Target date</th>
						<th>Is done ?</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
			
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
							<td><a href = "delete-todo?id=${todo.id}" class = "btn btn-warning">Delete</a></td>
							<td><a href = "update-todo?id=${todo.id}" class = "btn btn-success">Update</a></td>
							
						</tr>
					</c:forEach>
				</tbody>		
			</table>
			
			<a href = "add-todos" class = "btn btn-success"> Add Todo's</a>
			
		</div>
		
		<script src = "webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src = "webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>