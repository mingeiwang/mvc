<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/panduan.do" method="post">
		账号：<input type="text" name="name" value="" ><br/>
		密码：<input type="password" name="password" value=""><br/>
		注释：<input type="text" name="mess" value=""><br/>
		<input type="submit">
	</form>
</body>
</html>