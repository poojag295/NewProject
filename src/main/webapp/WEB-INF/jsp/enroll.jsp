<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student Enrollment</title>
</head>
<body>
    <h2>Student Enrollment Form</h2>

    <form:form method="POST" action="/save" modelAttribute="student">
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

        <p>First Attempt:
            <form:checkbox path="firstAttempt" />
        </p>

        <p>Subjects:
            <form:checkboxes path="subjects" items="${subjects}" />
        </p>

        <button type="submit">Save</button>
    </form:form>

    <p><a href="/viewstudents/1">View Students</a></p>
</body>
</html>
