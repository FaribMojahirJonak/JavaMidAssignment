<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Person List</title>
</head>
<body>

<input type="button" value="Add Employee"
				   onclick="window.location.href='insertEmployee.jsp'; return false;"
			/>

<table border="1">

    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Joining Date (YYYY/MM/DD)</th>
        <th>Employee Type</th>
        <th>Vacation Leave</th>
        <th>Sick Leave</th>
        <th>Action</th>
    </tr>

    <c:forEach var="employeeList" items="${employeeList}">
        <c:url var="update" value="first">
            <c:param name="COMMAND" value="UPDATE_PAGE" />
            <c:param name="id" value="${employeeList.id}" />
            <c:param name="name" value="${employeeList.name}" />
            <c:param name="joiningDate" value="${employeeList.joiningDate}" />
            <c:param name="employeeType" value="${employeeList.employeeType}" />
        </c:url>
        <c:url var="delete" value="first">
            <c:param name="COMMAND" value="DELETE" />
            <c:param name="id" value="${employeeList.id}" />
        </c:url>

        <tr>
            <td> ${employeeList.id} </td>
            <td> ${employeeList.name} </td>
            <td> ${employeeList.joiningDate} </td>
            <td> ${employeeList.employeeType} </td>
            <td> ${employeeList.vacationLeave} </td>
            <td> ${employeeList.sickLeave} </td>
            <td>
                <a href="${update}">Update</a>
                 |
                <a href="${delete}"
                onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">
                Delete</a>
            </td>
        </tr>

    </c:forEach>

</table>

</body>
</html>