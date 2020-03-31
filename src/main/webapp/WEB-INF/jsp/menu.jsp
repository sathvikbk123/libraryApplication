<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<nav class="navbar navbar-dark"
	style="background-color: #484c7f; color: white; padding: 20px 10px 20px 5px;">
	<h1>
		<a style="color: white; margin-left: 70px;" href="${pageContext.request.contextPath}/welcome"><i
			class="fas fa-book"></i> PLAsMa</a> &nbsp;
	</h1>
	<a href="${pageContext.request.contextPath}/findBook"
		class="btn btn-secondary" style="padding: 5px 5px 5px 5px;"> <i style="font-size:1.4rem;" class="fas fa-search"></i>
	</a>
	<h3>
		<i class="fas fa-robot"></i> Your Library Assistant
	</h3>
</nav>