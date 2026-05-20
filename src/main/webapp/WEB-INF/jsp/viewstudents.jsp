<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Students</title>
</head>
<body>
    <h2>Students List</h2>

    <p><a href="/enroll">Add Student</a></p>

    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Section</th>
            <th>Action</th>
        </tr>

        <c:forEach var="student" items="${list}">
            <tr>
                <td>${student.id}</td>
                <td>${student.firstName} ${student.lastName}</td>
                <td>${student.email}</td>
                <td>${student.country}</td>
                <td>${student.section}</td>
                <td>
                    <a href="/editstudent/${student.id}">Edit</a>
                    |
                    <a href="/deletestudent/${student.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <p>
        <c:forEach var="page" items="${pageCount}">
            <a href="/viewstudents/${page}">${page}</a>
        </c:forEach>
    </p>
</body>
</html>
