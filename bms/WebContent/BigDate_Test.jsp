<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	.err {
		color: red;
		font-size: 9px;
		display: none;
	}
</style>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#login").click(function(){
			alert("test");
			var id = $("#id").val();
			var pw = $("#pw").val();
			
			if( id == "" || pw == ""){
				alert("id");
				$("#err_ck").css("display","block");
			}
		});	
	});
</script>
<title>로그인</title>
</head>
<body>
<form action="BigDate_login" id="login_bd" name="lobin_bd" method="POST">
<div id="id_div">
	<input type="text" id="id" name="id" placeholder="아이디">
</div>
<div id="pw_div">
	<input type="password" id="pw" name="pw" placeholder="비밀번호">
	<span class="err" id="err_ck">아이디와 비밀번호를 모두 입력해 주세요</span>
</div>
	<button id="login">로그인</button>
	<button>초기화</button>
</form>
</body>
</html>