<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Cadastro de Cursos</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
<script src="scripts/jquery-1.7.1.js"></script>
<script src="scripts/js-webshim/minified/extras/modernizr-custom.js"></script>
<script src="scripts/js-webshim/minified/polyfiller.js"></script>
<script>
	$.webshims.setOptions('forms-ext', { replaceUI: false });
	$.webshims.polyfill('forms-ext');
</script>
</head>
<body>
	<div id="wrapper">
		<header role="banner" class="group">
			<div id="logo">Cadastro de Curso</div>
		</header>

		<div id="content" role="main">
		
		<fieldset>
			<h2>Cadastro de Cursos</h2>
			<label>Total de Cursos Cadastrados:</label><c:out value="${curso.size()}" />
				<c:choose>
				<c:when test="${curso.size() > 0}">
					<form id="form1" action="excluiCurso">
						<div id="flex">
							<b data-col='1'>Del</b>
							<b data-col='2'>Nome</b>
							<b data-col='3'>Descrição</b>
							<c:forEach items="${curso}" var="cur">
								<input type="checkbox" name="curid" value="${cur.id}" data-col="1"/>
								<span data-col="2"><c:out value="${cur.nome}" /></span>
								<span data-col="3"><c:out value="${cur.descricao }" /></span>
							</c:forEach>
						</div><div>
							<input type="submit" id="submit" value="Cadastrar Curso" formaction="inicio">
							<input type="submit" id="submitL" value="Deletar os itens selecionados">
						</div>
					</form>
				</c:when>
				<c:otherwise>
					<form id="form1" action="inicio">
						<input type="submit" id="submit" value="Cadastrar Curso">
					</form>
				</c:otherwise>
				</c:choose>
		</fieldset>
		</div>

	</div>
</body>
</html>