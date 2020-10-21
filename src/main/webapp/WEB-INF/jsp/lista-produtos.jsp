<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gustavo
  Date: 21/10/2020
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produtos</title>
</head>
<body>

<ul>
    <c:forEach var="produto" items="${produtoList}">
        <li><a href="/produtos/${produto.id}">${produto.nome}</a></li>
    </c:forEach>
</ul>


<a href="novo">Novo produto</a>
</body>
</html>
