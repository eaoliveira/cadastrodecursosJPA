<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Cadastro de Curso</title>
<link rel="stylesheet" type="text/css" href="styles/style.css"/>
<script src="scripts/jquery-1.7.1.js"></script>
<script src="scripts/js-webshim/minified/extras/modernizr-custom.js"></script>
<script src="scripts/js-webshim/minified/polyfiller.js"></script>
<script>
	$.webshims.setOptions('forms-ext', { replaceUI : false });
	$.webshims.polyfill('forms-ext');
</script>
</head>
<body>
	<div id="wrapper">
		<header role="banner" class="group">
			<div id="logo">Escola 1/2 boca</div>
		</header>

		<div id="content" role="main">
			<fieldset>
				<h2>Novo Curso</h2>
				<form id="form1" action="gravaCurso" method="post">
					<div>
						<label for="nome">Nome</label>
						<input type="text"  name="nome"  required />
					</div><div>
						<label for="descricao">Descricao</label>
						<textarea name="descricao" required></textarea>
								</div><div>
						<input type="submit" id="submit" value="Salvar"> 
					</div>
				</form>
			</fieldset>
		</div>

	</div>
</body>
</html>