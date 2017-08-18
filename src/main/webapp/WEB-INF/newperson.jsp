<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<title>New Person</title>
	</head>
	<body>
		<h1>New Person</h1>
		<form:form method="POST" action="/persons/new" modelAttribute="person">
    		<form:label path="firstName">First Name:
    		<form:errors path="firstName"/>
    		<form:input path="firstName"/></form:label>

    		<br>
    
    		<form:label path="lastName">Last Name:
    		<form:errors path="lastName"/>
    		<form:textarea path="lastName"/></form:label>
    
    		<input type="submit" value="Create"/>
		</form:form>
	</body>
</html>