<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<style>
<%@include file="/WEB-INF/css/style.css" %>
</style>
<body>

<div class="login">
	<small>${message}</small>
	<form action="/training/Auth" method="post">
		<input type="text" name="name" placeholder="名前を入力"/>
		<input type="password" name="pass" placeholder="パスワードを入力" />
		<input type="submit" value="ログイン">
	</form>
</div>

</body>
</html>