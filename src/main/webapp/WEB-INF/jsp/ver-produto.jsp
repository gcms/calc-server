<%--
  Created by IntelliJ IDEA.
  User: gustavo
  Date: 21/10/2020
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>
    ID: ${produto.id}
</p>
<p>
    Nome: ${produto.nome}
</p>
<p>
    Preço: ${produto.preco}
</p>

<a href="/produtos/excluir/${produto.id}">Excluir</a>
</body>
</html>
