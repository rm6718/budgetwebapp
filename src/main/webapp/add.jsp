<%--
  Created by IntelliJ IDEA.
  User: sam
  Date: 10/5/16
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Line Item</title>
</head>
<body>
Please input your line item data and click 'Save'!

<form action="/mybudget/create" method="post">
    <table>
        <tr> <td>Decription:            </td><td><input type="text" name="lDesc"></td></tr>
        <tr><td>Category:               </td><td><input type="text" name="lCat"></td></tr>
        <tr><td>Budgeted Amount:        </td><td><input type="text" name="lBA"></td></tr>
        <tr><td>Actual Amount:          </td><td><input type="text" name="lAA"></td></tr>

    </table>
    <input type="submit" name="Save" />
</form>
</body>
</html>
</body>
</html>
