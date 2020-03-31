<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<head>
    <link rel="stylesheet" href="styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
        integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Welcome to PLAsMa</title>
</head>

<body>
    <nav class="navbar navbar-dark">
        <h1><a href="${pageContext.request.contextPath}/welcome"><i class="fas fa-book"></i> PLAsMa</a> &nbsp;</h1>
        <form:form action="/findBook" method="POST" modelAttribute="bk5">
            <form:input type="text" path="book_name" placeholder="Search" style="padding: 3px 2px 4px 2px; border-radius: 3px; border:none" />
            <form:button type="submit" class="btn btn-secondary"><i class="fas fa-search"></i></form:button>
        </form:form>
        <h3><i class="fas fa-robot"></i> Your Library Assistant</h3>
    </nav>
    <div id="addBook" class="container" style="text-align:center">
        <h1 class="btn btn-secondary sc" style="font-size: 2.8rem; margin: 20px auto 30px auto;"><i class="fas fa-book-open"></i> Total Copies =
            ${totalCount}</h1>
        <h1 class="btn btn-danger sc" style="font-size: 2.8rem; margin: 20px auto 20px auto;"><i class="fas fa-book-reader"></i> Available copies =
            ${isAvailableCount}</h1>
    </div>
</body>

</html>