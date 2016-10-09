<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sam
  Date: 10/5/16
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Line Item</title>
</head>
<body>
Please edit your line item data and click 'Update'!

<form action="/mybudget/update" method="post">
    <table>
        <tr> <td>Decription:            </td><td><input type="text" name="lDesc" value="<c:out value="${myEdit.description}"/>"></td></tr>
        <tr><td>Category:               </td><td><input type="text" name="lCat" value="<c:out value="${myEdit.category}"/>"></td></tr>
        <tr><td>Budgeted Amount:        </td><td><input type="text" name="lBA" value="<c:out value="${myEdit.ba}"/>"></td></tr>
        <tr><td>Actual Amount:          </td><td><input type="text" name="lAA" value="<c:out value="${myEdit.aa}"/>"></td></tr>

    </table>
    <input type="submit" name="Update" />
    <input type="hidden" name="lId" value="<c:out value="${myEdit.id}"/>"/>
</form>
</body>
</html>
</body>
</html>