<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1><% out.print("JSP"); %></h1>

<b>O resultado de ${param.a} + ${param.b} é ${param.a + param.b}</b>
<p>Hoje é <%= new java.util.Date() %>.</p>


<p>
    METHOD: ${pageContext.request.getMethod()}
</p>

<c:forEach var="h" items="${header}">
    <p>${h.getKey()}: ${h.getValue()}</p>
</c:forEach>