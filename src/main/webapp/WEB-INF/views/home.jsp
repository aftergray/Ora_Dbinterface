<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style>
	table {
	margin:0 auto;/*가운데정렬*/
	border-collapse:collapse;/*테이블테두리간격없애기*/
	border:1px solid black;
	}
	tr,th,td {border:1px solid black;}
	div {text-align:center;}
	input {width:80px;}
	</style>
	
<!-- 달력사용 -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script src="./jquery-ui-1.12.1/datepicker-ko.js"></script>

	
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<div>
<h3>회원등록</h3>
<form name="form_insert" action="<c:url value='/' />member_insert" method="post">
<div>
<label>아이디</label>
<input name="userid" type="text" required />
<label>암호</label>
<input name="userpw" type="password" required />
<label>이름</label>
<input name="username" type="text" required />
<label>이메일</label>
<input name="email" type="text" required />
<button type="submit">회원등록</button>
</div>
</form>
<h3>회원리스트</h3>
<table>
<tr>
<th>사용자ID</th>
<th>암호</th>
<th>이름</th>
<th>이메일</th>
<th>등록일</th>
<th>수정일</th>
<th>수정/삭제</th>
</tr>
<c:forEach items="${memberList}" var="memberVO" varStatus="cnt">
<tr>
<form name="form_action" action='<c:url value="/" />member_update' method="post">
<td><input name="userid" value="${memberVO.userid}"></td>
<td><input name="userpw" value="${memberVO.userpw}"></td>
<td><input name="username" value="${memberVO.username}"></td>
<td><input name="email" value="${memberVO.email}"></td>
<td><input class ="date1" name="regdate" value='<fmt:formatDate pattern="yyyy-MM-dd hh:MM:ss" value="${memberVO.regdate}" />'></td>
<td><input class="date2" name="updatedate" value='<fmt:formatDate pattern="yyyy-MM-dd hh:MM:ss" value="${memberVO.updatedate}" />'></td>
<td>
<button class="btn_update" type="button">수정</button>
<button class="btn_delete" type="button">삭제</button>
</td>
</form>
</tr>
</c:forEach>
</table>
</div>
<script>
$(document).ready(function(){
	$(".date1").datepicker({ dateFormat: 'yy-mm-dd' });
	$(".date2").datepicker({ dateFormat: 'yy-mm-dd' });
	$(".btn_update").on("click",function() {
		//alert("수정버튼클릭");
		var click_element = $(this).parent().parent().find("form[name='form_action']");
		//alert(click_element.attr('name'));//디버그
		click_element.submit();
	});
	$(".btn_delete").on("click",function() {
		//alert("삭제버튼클릭");
		if(confirm("정말로 삭제하시겠습니까?")) {
			var click_element = $(this).parent().parent().find("form[name='form_action']");
			click_element.attr("action","<c:url value='/' />member_delete");
			click_element.submit();
		}
	});
});
</script>
</body>
</html>
