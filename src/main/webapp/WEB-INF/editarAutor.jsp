<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8" />
<title>Editar Editora</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
	integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="header.jsp">
	    <jsp:param name="header" value=""/>
	</jsp:include>

	<form action="/salvarEdicaoAutor" method="post"
		style="margin-top: 75px;">
		<div class="container">
			<div class="form-group">
				<input type="text" class="form-control" id="idautor" name="idautor"
					required value="${autor.idautor}" style="display: none;">
			</div>
			<div class="form-group">
				<label for="nomeAutor" class="control-label">Nome do Autor</label> <input
					type="text" class="form-control" id="nome" name="nome" required
					value="${autor.nome}">
			</div>

			<div class="form-group">
				<label for="nacionalidadeAutor" class="control-label">Nacionalidade</label>
				<input type="text" class="form-control" id="nacionalidade"
					name="nacionalidade" value="${autor.nacionalidade}" required>
			</div>
			<div class="form-group">
				<!-- Submit Button -->
				<button type="submit" class="btn btn-primary">Salvar</button>
			</div>
		</div>
	</form>
	
	

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"
		integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em"
		crossorigin="anonymous"></script>
</body>
</html>

<jsp:include page="footer.jsp">
	    <jsp:param name="footer" value=""/>
	</jsp:include>

	