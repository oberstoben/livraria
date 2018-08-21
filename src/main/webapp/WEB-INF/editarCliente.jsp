<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8" />
<title>Editar Cliente</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css"
	integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="header.jsp">
	    <jsp:param name="header" value=""/>
	</jsp:include>
	
	private Long id;
	private String nome;
	private String cpf;
	private int idade;
	private String endereco;
	private String email;

	<form action="/salvarEdicaoCliente" method="post" style="margin-top: 75px;">
		<div class="container">
			<div class="form-group">
				<input type="text" class="form-control" id="id" name="id"
					required value="${cliente.id}" style="display: none;">
			</div>
			<div class="form-group">
				<label for="nome" class="control-label">Nome do Cliente</label> <input
					type="text" class="form-control" id="nome" name="nome" required
					value="${cliente.nome}">
			</div>

			<div class="form-group">
				<label for="cpf" class="control-label">CPF</label>
				<input type="text" class="form-control" id="cpf"
					name="cpf" value="${cliente.cpf}" required>
			</div>
			<div class="form-group">
				<label for="idade" class="control-label">Idade</label>
				<input type="text" class="form-control" id="idade"
					name="idade" value="${cliente.idade}" required>
			</div>
			<div class="form-group">
				<label for="cpf" class="control-label">Endereco</label>
				<input type="text" class="form-control" id="endereco"
					name="endereco" value="${cliente.endereco}" required>
			</div>
			<div class="form-group">
				<label for="cpf" class="control-label">E-mail</label>
				<input type="text" class="form-control" id="email"
					name="email" value="${cliente.email}" required>
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

	