<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Person List</title>
</head>
<body>

<form action="first" method="GET">

    <input type="hidden" name="COMMAND" value="UPDATE" />

    <table>
        <tbody>
            <tr>
                <td><label>Id:</label></td>
                <td><input type="text" name="id" value="${employeeList.id}" /></td>
            </tr>

            <tr>
                <td><label>Name:</label></td>
                <td><input type="text" name="name" value="${employeeList.name}" /></td>
            </tr>

            <tr>
                <td><label>Joining Date:</label></td>
                <td><input type="text" name="joiningDate" value="${employeeList.joiningDate}" /></td>
            </tr>

            <tr>
                <td><label>Employee Type:</label></td>
                <td>
                    <select name="employeeType" id="employeeType">
                        <option value="officer" ${employeeList.employeeType eq 'officer' ? 'selected' : ''}>Officer</option>
                        <option value="staff" ${employeeList.employeeType eq 'staff' ? 'selected' : ''}>Staff</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Update" /></td>
            </tr>

        </tbody>
    </table>
</form>

</body>
</html>