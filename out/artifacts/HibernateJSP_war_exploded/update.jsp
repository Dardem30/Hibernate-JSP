<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: УВД
  Date: 29.05.2017
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/save">
        <input type="text" name="idhero" readonly="readonly" value="<c:out value="${hero.idhero}"/>">
        <input type="text" name="name" value="<c:out value="${hero.name}"/>">
    <input type="submit" value="ok" name="update">
</form>
</body>
</html>
