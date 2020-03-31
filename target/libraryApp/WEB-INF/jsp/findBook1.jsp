<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
        integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Search Result</title>
</head>

<body>
    <jsp:include page="menu.jsp" />
    <div id="findBook" class="container" style="text-align:center; margin-top: 20px">
        <h1 class="btn btn-success sc" style="font-size: 2.8rem;"><i class="fas fa-smile"></i>Total Copies = ${totalCount}</h1>
        <h1 class="btn btn-success sc" style="font-size: 2.8rem;"><i class="fas fa-smile"></i>Available copies = ${isAvailableCount}</h1>
    </div>
</body>

</html>