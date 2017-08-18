<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<title>New License</title>
	</head>
	<body>
		<h1>New License</h1>
		<form:form method="POST" action="/licenses/new" modelAttribute="license">
    		<form:label path="person">Person:
    		<form:errors path="person"/>
    		<form:select path="person" items="${persons}" itemValue="id" itemLabel="fullName"/></form:label>

    		<br>
    
    		<form:label path="state">State:
    		<form:errors path="state"/>
    		<form:input path="state"/></form:label>
        	
    		<br>

        	<form:label path="expiration_date">Date:
    		<form:errors path="expiration_date"/>
    		<form:input type="date" path="expiration_date"/></form:label>
    
    		<input type="submit" value="Create"/>
    		
		</form:form>
	</body>
</html>