<%--
  Created by IntelliJ IDEA.
  User: MTL
  Date: 2017/10/17
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script charset="utf-8" src="kindeditor/kindeditor.js"></script>
    <script>
        KE.show({
            id : 'editor_id',
            width : '100%',
            height : '100%'
        });
    </script>
    <style type="text/css">
        body {
            margin: 20px;
        }
    </style>
</head>
<body>
<form action="servlet/adminServlet?method=addText" method="post">
    <div><input type="submit" value="保存"></div>
    <textarea id="editor_id" name="text">${text}</textarea>
</form>
</body>
</html>
