<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Person List</title>
</head>
<body>

<form action="first" method="POST">

    <input type="hidden" name="COMMAND" value="CREATE" />

    <table>
        <tbody>
            <tr>
                <td><label>Id:</label></td>
                <td><input type="text" name="id" /></td>
            </tr>

            <tr>
                <td><label>Name:</label></td>
                <td><input type="text" name="name" /></td>
            </tr>

            <tr>
                <td><label>Joining Date(YYYY/MM/DD):</label></td>
                <td><input type="text" name="joiningDate" /></td>
            </tr>

            <tr>
                <td><label>Employee Type:</label></td>
                <td>
                    <select name="employeeType" id="employeeType">
                        <option value="officer">Officer</option>
                        <option value="staff">Staff</option>
                    </select>
                </td>
            </tr>


            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Create" /></td>
            </tr>

        </tbody>
    </table>
</form>

</body>
</html>