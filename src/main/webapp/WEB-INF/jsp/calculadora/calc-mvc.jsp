<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>Spring MVC</h1>

ID: ${id}
<b>O resultado de ${param.a} + ${param.b} é ${soma}</b>
<p>Hoje é <%= new java.util.Date() %>.</p>


<p>
    METHOD: ${pageContext.request.getMethod()}
</p>

<c:forEach var="h" items="${header}">
    <p>${h.getKey()}: ${h.getValue()}</p>
</c:forEach>