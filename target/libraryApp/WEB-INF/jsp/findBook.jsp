<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<link rel="stylesheet" href="styles.css">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
		integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<title>Find Book</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div id="addBook" class="container" style="text-align:center">
		<h1>Find Book</h1>
		<form:form action="/findBook" method="post" modelAttribute="bk5">
			<p>
				<label>Enter Book Name</label><br>
				<form:input path="book_name" />
			</p>
			<form:button type="SUBMIT" class="btn btn-primary">Submit</form:button>
		</form:form>
	</div>
</body>
</html>
