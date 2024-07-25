<html>
	<head>
		<link href = "webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel = "stylesheet">
		
		<title> 
			LOGIN PAGE
		</title>	
	</head>
	
	<body>
		<div class = "container">
			<h1>
				WELCOME TO LOGIN PAGE
			</h1>
			
			Hey there, Your login page is here!
			
			<pre>${ErrorMessage}</pre>
			
			<form method = "post">
				Name : <input type = "text" name = "name">
				Password : <input type = "password" name = "password"> 
				<input type = "submit" class = "btn btn-success">
			</form>	
		</div>
		
		<script src = "webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src = "webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>