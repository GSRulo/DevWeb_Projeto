<%@page import="model.Pais"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visualizar Pa&iacute;s</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Import top menu bar -->
	<c:import url="Menu.jsp" />

	<!-- Container Main -->
	<h3 class="page-header">Alterar Pa&iacute;s #${pais.id}</h3>

	<!-- Inclusion Form -->
	<form action="controller.do" method="post">

		<!-- Area Form -->
		<input type="hidden" name="id" value="${pais.id }" />
		<div class="row">
			<div class="form-group col-md-12">
				<label for="nome">Nome:</label> <input type="text"
					class="form-control" name="name" id="name" required maxlength="100"
					placeholder="Nome">
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-6">
				<label for="populacao">Tamanho da Popula&ccedil;&atilde;o:</label> <input
					class="form-control" name="populacao" id="populacao" maxlength="15"
					placeholder="Tamanho da Popula&ccedil;&atilde;o">
			</div>

			<div class="form-group col-md-6">
				<label for="area">Extens&atilde;o Territorial:</label> <input
					class="form-control" name="area" id="area" required maxlength="60"
					placeholder="Extens&atilde;o Territorial">
			</div>
		</div>
		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<button type="submit" class="btn btn-primary" name="command"
					value="AlterarPais">Salvar</button>
				<a href="ListarPaises.jsp" class="btn btn-primary">Cancelar</a>
			</div>
		</div>
	</form>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>