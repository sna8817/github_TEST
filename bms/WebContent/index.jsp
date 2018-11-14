<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<style type="text/css">
	@import url('https://fonts.googleapis.com/css?family=Jua');
	body {
		margin: 0px; padding: 0px; font-family: 'Jua', sans-serif;
	}
	a {text-decoration: none;}
	#content {
		width: 260px;
		height: 400px;
		border: 2px solid black;
		margin: 0 auto;
		margin-top: 50px;
		background-color: #d8e9ef;
		border-radius: 5px;
	}
	#bms_title {
		display: block;
		padding-top: 25px;
		text-align: center;
		font-size: 20px;
		color: black;
	}
	#bms_manager {
		padding-top: 10px;
		padding-bottom: 40px;
		text-align: center;
		color: #454552;
	}
	.div_index {
		padding-bottom: 22px;
		text-align: center;
	}
	.btn_index {
		padding: 8px 12px;
		background-color: blue;
		color: white;
		width: 79px;
		display: inline-block;
		border-radius: 10px;
	}
	.btn13 {background-color: #43a1d3;}
	.btn24 {background-color: #e85a71;}
	.btn13:hover {background-color: #3c8cBE;}
	.btn24:hover {background-color: #D2465A;}
	
</style>
</head>
<body>
	<div id="content">
		<a href=""><span id="bms_title">자바기반 빅데이터<br>개발자과정 2기</span></a>
		<div id="bms_manager">- 학사관리 -</div>
		
		<div class="div_index">
			<!-- href="insert.jsp" 화면단에서 화면단으로바로 넘어가는거 금지, 무조건 컨트롤러단을 거치고 가야한다! -->
			<a href="BmsInsert" class="btn_index btn13">학생등록</a>
		</div>
		<div class="div_index">
			<a href="" class="btn_index btn24">학생수정</a>
		</div>
		<div class="div_index">
			<a href="" class="btn_index btn13">등록취소</a>
		</div>
		<div class="div_index">
			<a href="BmsSelect" class="btn_index btn24">출석부</a>
		</div>
		
	</div>
</body>
</html>