<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!DOCTYPE html>
<html>


<body>
<h2 align="center">My Budget Summary</h2>


<a href="/mybudget/lineitems">Line Item Details</a>


<table border="1" align="center">
    <tr><th>Totals</th><th>All Categories</th><th>Leisure</th><th>Eating</th><th>Rent</th><th>Transportation</th></tr>
    <c:forEach items="${summary}" var="sum">

        <tr align="center">
            <td><c:out value="${sum.alltotal}"/></td>
            <td><c:out value="${sum.leisure}"/></td>
            <td><c:out value="${sum.eating}"/></td>
            <td><c:out value="${sum.rent}"/></td>
            <td><c:out value="${sum.transport}"/></td></tr>
    </c:forEach>
</table>


</body>
</html>
