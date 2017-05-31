<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: УВД
  Date: 29.05.2017
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${list}" var="list">
        <tr>
            <th>${list.idhero}</th>
            <th>${list.name}</th>
            <th><a href="/save?action=update&idhero=<c:out value="${list.idhero}"/>">update</a> </th>
            <th><a href="/save?action=delete&idhero=${list.idhero}">delete</a> </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
