<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Novo</title>
<link href="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-3.6.0-dist/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="/public/public-nav.jsp" />
	<div class="container p-5">
			<div class="row bg-primary rounded">
				<div class="col">
					<h2 class="text-white text-center p-2">Cadastro de Computador</h2>
				</div>
			</div>
			<form action="${pageContext.request.contextPath}/public?acao=inserir" method="post" class="mt-3">
				<div class="form-group">
					<label for="marca">Marca:</label>
					<input type="text" name="marca" value="" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="memoria">Memória:</label>
					<input type="number" name="memoria" value="" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="preco">Preço:</label>
					<input type="number" name="preco" value="" class="form-control"/>
				</div>
				<input type="submit" class="btn btn-primary mt-3" value="inserir" />
			</form>
		</div>
</body>
</html>