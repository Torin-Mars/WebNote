package com.mtl.control;

import com.mtl.pojo.Node;
import com.mtl.pojo.Text;
import com.mtl.service.NodeService;
import com.mtl.service.impl.NodeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminServlet extends BaseServlet {
    private int nowId = 0;
    private NodeService nodeService = new NodeServiceImpl();

    protected void doAddNode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("doId = " + request.getParameter("doId"));
        nodeService.addNode(nowId, request.getParameter("doId"), request.getParameter("name"));



        getAllNodeIndex(request, response);

    }

    protected void getAllNodeIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Node> nodeList = nodeService.getAllNode();
        System.out.println("nodeList.size = " + nodeList.size());
        req.setAttribute("nodeList", nodeList);
        req.getRequestDispatcher("/dtree/left.jsp").forward(req, resp);
    }

    protected void getNodeById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null && !"".equals(id)){
            nowId = Integer.valueOf(id);
        }
        Text text = nodeService.getNodeById(nowId);
        if (text == null) {
            req.getSession().setAttribute("text", "");
        } else {
            req.getSession().setAttribute("text", text.getText());
        }
//        req.getRequestDispatcher("/main.jsp").forward(req, resp);

        resp.sendRedirect(req.getContextPath() + "/main.jsp");
    }

    protected void deleteNodeById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        nodeService.deleteNodeById(nowId);
        getAllNodeIndex(req, resp);
    }

    protected void toUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入toUp");
        nodeService.changeNodeTextUp(nowId);
        getAllNodeIndex(req, resp);
    }

    protected void toDown(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入toDown");
        nodeService.changeNodeTextDown(nowId);
        getAllNodeIndex(req, resp);
    }

    protected void toRight(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入toRight");
        nodeService.changeNodeTextRight(nowId);
        getAllNodeIndex(req, resp);
    }

    protected void toLeft(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入toLeft");
        nodeService.changeNodeTextLeft(nowId);
        getAllNodeIndex(req, resp);
    }

    protected void addText(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        System.out.println("text = " + text);
        nodeService.deleteText(nowId);
        nodeService.addText(new Text(nowId, text));
//        req.getRequestDispatcher("/main.jsp").forward(req, resp );
        getNodeById(req, resp);

    }
}