<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select(학생조회)</title>
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
	.btn24 {background-color: #e85a71;}
	.btn24:hover {background-color: #D2465A;}
	
	#in_content {
		width: 234px;
		margin: 0 auto;
		height: 190px;
		overflow: auto;
	}
	table {
		font-size: 13px;
		border-collapse: collapse;
		border-spacing: 0;
		display: table;
		width: 234px;
	}
	#table_title {
		background-color: #4ea1d3;
		height: 20px;
		color: white;
		border: 0px;
	}
	.table_data {
		background-color: white;
		height: 20px;
		font-size: 12px;
	}
	td {padding: 5px;}
	th {text-align: center;}
	tr {border-bottom: 1px dashed #BBBBBB;}
	.a_update {color: blue;}
	.a_delete {color: red;}
</style>
</head>
<body>
	<div id="content">
		<a href="index"><span id="bms_title">자바기반 빅데이터<br>개발자과정 2기</span></a>
		<div id="bms_manager">- 학생조회 -</div>
		<div id="in_content">
			<table>
				<tr id="table_title">
					<td>ID</td>
					<td>Name</td>
					<td>Tel.</td>
					<td></td>
					<td></td>
				</tr>
				
				<c:forEach items="${bmslist}" var="BmsDTO">
					<tr class="table_data">
						<td>${BmsDTO.id}</td>
						<td>${BmsDTO.name}</td>
						<td>${BmsDTO.phone}</td>
						
<%-- 						방법1
						fomr태그로 감싸기 => 코드 변경됨
						<form action="BmsUpdate">
							<input type="hidden" value="${BmsDTO.id}">
							<input type="hidden" value="${BmsDTO.name}">
							<input type="hidden" value="${BmsDTO.age}">
							<input type="hidden" value="${BmsDTO.major}">
							<input type="hidden" value="${BmsDTO.phone}">
						</form>
							방법2
						쿼리스트링 => GET방식으로 되어버림
						<td><a href="BmsUpdate?" id="a_update">수정</a></td>
							방법3
						컨트롤러단으로 이동>>>
							방법4
						아이디값만 쿼리스트링으로 보내서, 아이디값으로 다시 셀렉트 --%>
						<td><a href="BmsUpdate?userid=${BmsDTO.id}" class="a_update">수정</a></td>
						<!-- userid가 변수 값=> request.getpra..의 변수로 들어감 -->
						<td><a href="BmsDelete?userid=${BmsDTO.id}" class ="a_delete">삭제</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<div class="div_index">
			<a href="index" class="btn_index btn24">뒤로가기</a>
		</div>
		
		
	</div>
</body>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#delete_btn").click(function(){
			alert("삭제합니다.");
		});
	});
</script>
</html>