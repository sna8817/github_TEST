<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update.jsp</title>
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
		padding-bottom: 15px;
		text-align: center;
		color: #454552;
	}
	.div_index {
		padding-top: 22px;
		padding-bottom: 22px;
		text-align: center;
	}
	.btn_index {
		padding: 5px 8px;
		color: white;
		width: 50px;
		display: inline-block;
		border-radius: 10px;
	}
	.bms_index {
		width: 140px;
		display: inline-block;
		height: 18px;
	}
	#in_content {
		text-align: right;
	}
	.div_input {
		padding: 9px 20px;
		height: 24px;
		position: relative;
	}
	.div_input > label {
		float: left;
		line-height: 24px;
	}
	.span_ck {
		font-size: 12px;
		color: #e85a71;
		display: none;
		position: absolute;
		left: 98px;
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
		<div id="bms_manager">- 학생수정 -</div>
		
		<form action="BmsUpdate" method="POST" name="frmupdate" id="frmupdate">
			<c:forEach items="${onelist}" var="OneDTO">
				<div id="in_content">
					<div class="div_input">
						<label for="input_id">아이디: </label>
						<input type="text" id="input_id" name="input_id" class="bms_index" placeholder="ID를 입력" readonly="readonly" value="${OneDTO.id}">
						<span id="span_id" class="span_ck">ID를 입력하세요.</span>
					</div>
					
					<div class="div_input">
						<label for="input_name">이름: </label>
						<input type="text" id="input_name" name="input_name" class="bms_index" placeholder="이름을 입력" value="${OneDTO.name}">
						<span id="span_name" class="span_ck">이름 입력하세요.</span>
					</div>
					
					<div class="div_input">
						<label for="input_age">나이: </label>
						<input type="text" id="input_age" name="input_age" class="bms_index" placeholder="나이를 입력" value="${OneDTO.age}">
						<span id="span_age" class="span_ck">나이를 입력하세요.</span>
					</div>
					
					<div class="div_input">
						<label for="input_major">전공: </label>
						<input type="text" id="input_major" name="input_major" class="bms_index" placeholder="전공을 입력" value="${OneDTO.major}">
						<span id="span_major" class="span_ck">전공을 입력하세요.</span>
					</div>
					
					<div class="div_input">
						<label for="input_phone">핸드폰번호: </label>
						<input type="text" id="input_phone" name="input_phone" class="bms_index" placeholder="핸드폰번호를 입력" value="${OneDTO.phone}">
						<span id="span_phone" class="span_ck">핸드폰번호를 입력하세요.</span>
					</div>
				</div>
			</c:forEach>
			
			<!-- 
			버튼들
			1. <input type="submit">
				: 버튼동작시 => form태그의 action주소로 데이터를 가지고 전송
			2. <input type="button">
				: 버튼동작시 => 사용자가 지정한 기능을 수행
			3. <button>
				: 버튼동작시 => 사용자가 지정한 기능을 수행
			4. <a>
				: 버튼동작시 => href 주소로 이동
			
			ㄴ*submit이라는 속성을 사용해야만 form태그 안에 있는 데이터들을 모두 가지고 목적지로 전송*
			ㄴ button 클릭시 submit 실행!
			 -->
			
			<div class="div_index">
				<a href="#" id="update_btn" class="btn_index btn13">수정</a>
				<a href="#" class="btn_index btn24">취소</a>
			</div>
		</form>
		
	</div>
</body>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#update_btn").click(function(){
			/* form태그를 submit하세요 */
			$("#frmupdate").submit();
		});
		
	});
</script>
</html>