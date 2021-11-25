<%-- 
    Document   : resetNewPassword
    Created on : 24-Nov-2021, 2:19:38 PM
    Author     : lixia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Reset New Password Page</title>
	</head>
	<body>
		<h1>Enter a new password</h1>
		<form action="reset" method="POST">
			<input type="text" name="password" value="" />
			<input type="submit" value="Submit" />
			<input type="hidden" name="uuid" value="${uuid}"/>
		</form>
	</body>
</html>
