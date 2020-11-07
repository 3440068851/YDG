<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
	<style>
	h3{
		color="red";
	}
	</style>
	<script type="text/javascript">
		function changeimage(){
			document.getElementById("image1").src="/Javaweb_login2/GetImageCodeServlet?time="+new Date().getTime();
		}
	</script>
</head>
<body>
	<h1>登录界面</h1>
	<%
		String msg=" ";
		if(request.getAttribute("msg") != null){
			msg=(String)request.getAttribute("msg");
		}
	
	%>
	<h3><%=msg %></h3>
	<form action="/Javaweb_login2/Servletlogin2" method="get">
		<table width="300px" border="1px">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="username" value="${cookie.remember.value }"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>验证码</td>
				<td><input type="text" name="checkCode" size=6 ><img id="image1" src="/Javaweb_login2/GetImageCodeServlet" border="1px"></td>
				<td><a href="#" onclick="changeimage()">看不清，换一张</a></td>
			</tr>
			<tr>
				<td><input type="checkbox" value="true" name="remmeber"></td>
				<td>记住用户名和密码</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登录"></td>
			</tr>
		
		</table>
	
	</form>
</body>
</html>