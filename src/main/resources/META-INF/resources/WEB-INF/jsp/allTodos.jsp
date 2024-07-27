
		<%@ include file = "common/header.jspf" %>
		<%@ include file = "common/navigation.jspf" %>
	
		<div class = "container">
			<h1>WELCOME ${name}</h1>
			
			<hr>
			<h1>your todo's</h1>
		
			<table class = "table">
				<thead>
					<tr>
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
		
		<%@ include file="common/footer.jspf" %> 
		
	</body>
</html>