<%-- 
    Document   : newjsp1
    Created on : 20 nov. 2018, 13:56:58
    Author     : pedago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"% session="false">
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Devine un nombre</title>
	</head>
	<body onload="document.guessForm.guess.focus()">
		<hr>
		<h2>${login} joueurs connectés</h2>
		<hr>

		<h3>Hello ${login}, Devine mon nombre</h3>
		
		<h2>je pense à un nombre compris entre 0 et 100</h2>
		<form name="guessForm" method="POST" accept-charset="UTF-8" >
			<label>Ta proposition : <input type="number" min="0" max="100" required name="guess"></label> 
			<input type="SUBMIT" name="action" value="Deviner"><br/>
		</form>
		<form method="POST">
			<input type="SUBMIT" name="action" value="Déconnexion">
		</form>

		<hr>
		
			<h2>Score à battre : ${essai} essais par polo</h2>
				
	</body>
</html>
