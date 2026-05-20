<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
    <h2>Edit Student</h2>

    <form:form method="POST" action="/editsave" modelAttribute="student">
        <form:hidden path="id" />

        <p>First Name: <form:input path="firstName" /></p>
        <p>Last Name: <form:input path="lastName" /></p>
        <p>Email: <form:input path="email" /></p>
        <p>Date of Birth: <form:input path="dob" type="date" /></p>

        <p>Country:
            <form:select path="country">
                <form:options items="${countries}" />
            </form:select>
        </p>

        <p>Section:
            <form:select path="section">
                <form:options items="${sections}" />
            </form:select>
        </p>

        <p>Sex:
            <form:radiobutton path="sex" value="Male" /> Male
            <form:radiobutton path="sex" value="Female" /> Female
        </p>

        <button type="submit">Update</button>
    </form:form>
</body>
</html>
