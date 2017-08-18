<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Profile Page</title>
	</head>
	<body>
		<h1><c:out value="${person.fullName}"/></h1>
		<p>License Number: <c:out value="${person.license.number}"/></p>
		<p>State: <c:out value="${person.license.state}"/></p>
		<p>Expiration Date: <fmt:formatDate pattern="MM/dd/yyyy" value="${person.license.expiration_date}"/></p>
	</body>
</html>