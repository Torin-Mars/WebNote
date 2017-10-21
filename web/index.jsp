<%--
  Created by IntelliJ IDEA.
  User: MTL
  Date: 2017/10/17
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <base href="${basePath}">
  <meta charset="UTF-8">
  <title>欢迎界面</title>
</head>
<!--<frameset rows="5%,*" frameborder="no" border="0" framespacing="0">-->
<frameset rows="14%,*" frameborder="1" border="1" framespacing="0">
  <frame src="top.jsp" name="topFrame"/>
  <frameset  cols="16%,*" frameborder="1" border="1" framespacing="0">
    <frame src="servlet/adminServlet?method=getAllNodeIndex" name="leftFrame"/>
    <frame src="main.jsp" name="mainFrame"/>
  </frameset>
</frameset>



<!--</frameset>-->
</html>