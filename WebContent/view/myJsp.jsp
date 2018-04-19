<%@page import="service.vo.MessageVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% 
		MessageVO messageVO = (MessageVO)request.getAttribute("message");
		
	%>
	<table>
		<tr>
			<td><%=messageVO.getName() %></td>
			<td><%=messageVO.getDddd() %></td>
		</tr>
		<tr>
			<td><%=messageVO.getMess() %></td>
			<td><%=messageVO.getSsss() %></td>
		</tr>
	</table>
</body>
</html>