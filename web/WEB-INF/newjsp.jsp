<%-- 
    Document   : newjsp
    Created on : 20 nov. 2018, 13:56:01
    Author     : pedago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Devine un nombre</title>
	</head>
	<body>
		<h1>Bienvenue dans notre jeu !</h1>
		<hr>
		<h2> joueurs connectés</h2>
		<hr>

	<form method="POST">
		<label>Ton prénom : <input name="playerName"></label>
		<input name="action" value="Connexion" type="SUBMIT">
	</form>
</body>
</html>
