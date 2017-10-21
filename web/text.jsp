<%--
  Created by IntelliJ IDEA.
  User: MTL
  Date: 2017/10/19
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="dTreeNode">
    <img id="id0" src="img/base.gif" alt=""/>
    <a id="sd0" class="node" href="/servlet/adminServlet?method=getNodeById&id=1" title="aa" target="mainFrame" onclick="javascript: d.s(0);">title1</a>
</div>
<div id="dd0" class="clip" style="display:block;">
    <div class="dTreeNode">
        <a href="javascript: d.o(1);"><img id="jd1" src="img/minus.gif" alt=""/></a>
        <img id="id1" src="img/folderopen.gif" alt=""/>
        <a id="sd1" class="node" href="/servlet/adminServlet?method=getNodeById&id=2" title="aa" target="mainFrame" onclick="javascript: d.s(1);">电冰箱</a>
    </div>
    <div id="dd1" class="clip" style="display:block;">
        <div class="dTreeNode">
            <img src="img/line.gif" alt=""/>
            <a href="javascript: d.o(5);"><img id="jd5" src="img/minus.gif" alt=""/></a>
            <img id="id5" src="img/folderopen.gif" alt=""/>
            <a id="sd5" class="node" href="/servlet/adminServlet?method=getNodeById&id=8" title="aa" target="mainFrame" onclick="javascript: d.s(5);">电视机</a>
        </div>
        <div id="dd5" class="clip" style="display:block;">
            <div class="dTreeNode">
                <img src="img/line.gif" alt=""/>
                <img src="img/line.gif" alt=""/>
                <img src="img/joinbottom.gif" alt=""/>
                <img id="id7" src="img/page.gif" alt=""/>
                <a id="sd7" class="node" href="/servlet/adminServlet?method=getNodeById&id=16" title="aa" target="mainFrame" onclick="javascript: d.s(7);">音响</a>
            </div>
        </div>
        <div class="dTreeNode">
            <img src="img/line.gif" alt=""/>
            <img src="img/joinbottom.gif" alt=""/>
            <img id="id8" src="img/page.gif" alt=""/>
            <a id="sd8" class="node" href="/servlet/adminServlet?method=getNodeById&id=17" title="aa" target="mainFrame" onclick="javascript: d.s(8);">大夫</a>
        </div>
    </div>
    <div class="dTreeNode">
        <img src="img/join.gif" alt=""/>
        <img id="id2" src="img/page.gif" alt=""/>
        <a id="sd2" class="node" href="/servlet/adminServlet?method=getNodeById&id=3" title="aa" target="mainFrame" onclick="javascript: d.s(2);">大炮</a>
    </div>
    <div class="dTreeNode">
        <a href="javascript: d.o(3);"><img id="jd3" src="img/minus.gif" alt=""/></a>
        <img id="id3" src="img/folderopen.gif" alt=""/>
        <a id="sd3" class="node" href="/servlet/adminServlet?method=getNodeById&id=4" title="aa" target="mainFrame" onclick="javascript: d.s(3);">电脑</a></div>
    <div id="dd3" class="clip" style="display:block;">
        <div class="dTreeNode">
            <img src="img/line.gif" alt=""/>
            <img src="img/joinbottom.gif" alt=""/>
            <img id="id4" src="img/page.gif" alt=""/>
            <a id="sd4" class="node" href="/servlet/adminServlet?method=getNodeById&id=7" title="aa" target="mainFrame" onclick="javascript: d.s(4);">键盘</a></div>
    </div>
    <div class="dTreeNode">
        <img src="img/joinbottom.gif" alt=""/>
        <img id="id6" src="img/page.gif" alt=""/>
        <a id="sd6" class="node" href="/servlet/adminServlet?method=getNodeById&id=9" title="aa" target="mainFrame" onclick="javascript: d.s(6);">彩电</a>
    </div>
</div>
</body>
</html>
