<%@page import="model.Pais"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
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
        <div id="main" class="container">
            <h3 class="page-header">Visualizar Pa&iacute;s ##${pais.id} %></h3>
            <div class="row">
                <div class="col-md-12">
                    <p><strong>Nome</strong>
                    </p>
                    <p>
                        ${pais.nome}
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <p><strong>Popula&ccedil;&atilde;o</strong>
                    </p>
                    <p>
                        ${pais.populacao}
                    </p>
                </div>
                <div class="col-md-6">
                    <p><strong>&Aacute;rea</strong>
                    </p>
                    <p>
                        ${pais.area} km<sup>2</sup>
                    </p>
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="index.jsp" class="btn btn-default">Voltar</a>
                </div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>
</html>