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
	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Excluir País</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este
					pa&iacute;s?</div>
				<div class="modal-footer">
					<form action="ConsultaPais.do" method="post">
						<input type="hidden" name="id" id="id_excluir" />
						<button type="submit" class="btn btn-primary" name="acao"
							value="Excluir">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Import top menu bar -->
	<c:import url="Menu.jsp" />

	<!-- Container Main -->
	<div id="main" class="container">
		<h3 class="page-header">Visualizar Pa&iacute;s #${pais.id}</h3>
		<div class="row">
			<div class="col-md-12">
				<p>
					<strong>Nome</strong>
				</p>
				<p>${pais.nome }</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<p>
					<strong>Popula&ccedil;&atilde;o</strong>
				</p>
				<p>${pais.populacao }</p>
			</div>
			<div class="col-md-6">
				<p>
					<strong>&Aacute;rea</strong>
				</p>
				<p>
					${pais.area } km<sup>2</sup>
				</p>
			</div>
		</div>
		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="ConsultaPais.do?acao=Editar&id=${pais.id }"
					class="btn btn-primary">Editar</a> <a href="#"
					class="btn btn-danger" data-toggle="modal"
					data-target="#delete-modal">Excluir</a> <a href="ListarPaises.jsp"
					class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
</body>