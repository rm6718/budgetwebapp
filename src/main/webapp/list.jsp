<%--
  Created by IntelliJ IDEA.
  User: sam
  Date: 10/5/16
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Line Item Details</title>
</head>
<body>
Go back to Budget Summary <a href="/mybudget/summary">HERE</a>

Create New Line Item <a href="/mybudget/add.jsp">HERE</a>



<p></p>
<form action="/mybudget/search" method="post">
    Search <input type="text" name="searchtext"/>
    <br>
    <input type="submit" name="Filter Results"/>
</form>




<table border="1">
    <tr><th>Actions</th><th>Description</th><th>Category</th><th>Budgeted Amount</th><th>Actual Amount</th></tr>
    <c:forEach items="${lineitems}" var="aItem">
    <tr>
        <td><a href="/mybudget/select?id=<c:out value="${aItem.id}"/>">EDIT</a>
            <br>
            <a href="/mybudget/delete?id=<c:out value="${aItem.id}"/>">DELETE</a></td>
        <td><c:out value="${aItem.description}"/></td>
        <td><c:out value="${aItem.category}"/></td>
        <td><c:out value="${aItem.ba}"/></td>
        <td><c:out value="${aItem.aa}"/></td></tr>

</c:forEach>

</table>



</body>
</html>
