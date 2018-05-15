<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ダッシュボード</title>
<style>
<%@include file="/WEB-INF/css/style.css" %>
</style>
</head>
<body>
${name}さん
<div class="create">
	<small>${message}</small>
	<form action="/training/Practice" method="post">
		<textarea rows="10" cols="60" placeholder="ここに問題を記載" name="question"></textarea><br>
		選択1 : <input type="text" name="answer1"/><br>
		選択2 : <input type="text" name="answer2"/><br>
		選択3 : <input type="text" name="answer3"/><br>
		<br><br>
		解答No : <input type="text" name="answer"><br>
		<input type="submit" value="登録">
	</form>
</div>
</body>
</html>