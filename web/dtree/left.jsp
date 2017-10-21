<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <base href="${basePath}">
    <meta charset="UTF-8">
    <title>左边页面</title>
    <link href="dtree/dtree.css" rel="StyleSheet" type="text/css"/>
    <script type="text/javascript" src="dtree/dtree.js"></script>
    <style type="text/css">
        body {
            margin: 20px;
            margin-left: 40px;
        }
    </style>
</head>
<body >
<div >
    <a href="/servlet/adminServlet?method=toLeft">←</a>&nbsp;
    <a href="/servlet/adminServlet?method=toUp">↑</a>&nbsp;
    <a href="/servlet/adminServlet?method=toRight">→ </a>&nbsp;
    <a href="/servlet/adminServlet?method=toDown">↓</a>&nbsp;
    <a href="javascript: utilOnClick('addUp')" >+`</a>&nbsp;
    <a href="javascript: utilOnClick('addDown')">+、</a>&nbsp;
    <a href="javascript: utilOnClick('addSub')">+~</a>&nbsp;
    <a href="/servlet/adminServlet?method=deleteNodeById">-</a>&nbsp;

</div>
<div style="margin-top: 10px" id="div1" hidden>
    <form action="servlet/adminServlet?method=doAddNode" method="post">
        <input type="text" name="name" style="width: 100px;"/>
        <input type="hidden" name="pid" id="pid"/>
        <input type="hidden" name="doId" id="doId"/>
        <input type="submit" value="确定" onclick="onclick1()">
    </form>
</div>
<div class="dtree"><!--创建一个div层，指定class为“dtree”，此时该层就引用了dtree的样式 -->
    <script type="text/javascript">



        d = new dTree('d');//new一个树对象
        //设置树的节点及其相关属性

        <c:forEach items="${nodeList}" var="c">
            d.add(${c.id}, ${c.pid}, '${c.name}', '/servlet/adminServlet?method=getNodeById&id=${c.id}', 'aa', 'mainFrame', true);
            console.info('正在进行foreache');

        </c:forEach>
        //config配置，设置文件夹不能被链接，即有子节点的不能被链接。
//        d.config.folderLinks=false;
        document.write(d);
//        console.info("toString = " + d);
        console.info("info finashed");
    </script>
</div>

</body>
</html>