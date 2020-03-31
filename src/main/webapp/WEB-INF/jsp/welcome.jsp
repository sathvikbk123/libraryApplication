<%@page session="false"%>
<html>

<head>
<link href="styles.css" rel="stylesheet" type="text/css">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>Welcome to PLAsMa</title>
<style>
.card {
	margin: 20px auto 20px auto;
	text-align: center;
}
</style>
</head>

<body>
	<jsp:include page="menu.jsp" />
	<div class="container"
		style="margin-top: 30px; width: 70%; text-align: center;">
		<div class="row">
			<div class="col-sm">
				<div class="card" style="width: 15rem;">
					<img class="card-img-top" height="150px;"
						src="https://img.freepik.com/free-vector/books-stack-realistic_1284-4735.jpg?size=338&ext=jpg"
						alt="issue">
					<div class="card-body">
						<h5 class="card-title">Add Book</h5>
						<a class="btn btn-primary"
							href="${pageContext.request.contextPath}/addNewBook">Go there
							<i class="fas fa-angle-double-right"></i>
						</a> &nbsp;
					</div>
				</div>
			</div>
			<div class="col-sm">
				<div class="card" style="width: 15rem;">
					<img class="card-img-top"
						src="https://img.freepik.com/free-photo/stack-books-library-desk_23-2147845946.jpg?size=626&ext=jpg"
						alt="issue">
					<div class="card-body">
						<h5 class="card-title">Issue Book</h5>
						<a class="btn btn-primary"
							href="${pageContext.request.contextPath}/issueBook">Go there
							<i class="fas fa-angle-double-right"></i>
						</a> &nbsp;
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm">
				<div class="card" style="width: 15rem;">
					<img class="card-img-top"
						src="https://img.freepik.com/free-photo/bible-wood_1150-17659.jpg?size=626&ext=jpg"
						alt="issue">
					<div class="card-body">
						<h5 class="card-title">Remove Book</h5>
						<a class="btn btn-primary"
							href="${pageContext.request.contextPath}/deleteBook">Go there
							<i class="fas fa-angle-double-right"></i>
						</a> &nbsp;
					</div>
				</div>
			</div>
			<div class="col-sm">
				<div class="card" style="width: 15rem;">
					<img class="card-img-top"
						src="https://img.freepik.com/free-photo/crop-hand-taking-book-from-shelf_23-2147845909.jpg?size=626&ext=jpg"
						alt="issue">
					<div class="card-body">
						<h5 class="card-title">Return Book</h5>
						<a class="btn btn-primary"
							href="${pageContext.request.contextPath}/returnBook">Go there
							<i class="fas fa-angle-double-right"></i>
						</a> &nbsp;
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>