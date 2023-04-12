<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem</title>
<link href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/public/public-nav.jsp" />
	<div class="table-responsive">
	<table class="table table-striped table-hover">
	<thead class="thead-dark">
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Marca</th>
			<th scope="col">Memoria</th>
			<th scope="col">Preço</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="computador" items="${listaComputadores}" >
		<tr>
            <th scope="row"><c:out value="${computador.id}" /></td>
            <td><c:out value="${computador.marca}"/></td>
            <td><c:out value="${computador.memoria}"/></td>
            <td><c:out value="${computador.preco}"/></td>
        </tr>
	</c:forEach>
	<tbody>
	</table>
	</div>
</body>
</html>