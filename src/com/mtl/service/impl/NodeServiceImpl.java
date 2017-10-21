package com.mtl.service.impl;

import com.mtl.dao.ExeNodes;
import com.mtl.dao.ExeText;
import com.mtl.dao.impl.ExeNodesImpl;
import com.mtl.dao.impl.ExeTextImpl;
import com.mtl.pojo.Node;
import com.mtl.pojo.Text;
import com.mtl.service.NodeService;

import java.util.List;

public class NodeServiceImpl implements NodeService {
    private ExeNodes exeNodes = new ExeNodesImpl();
    private ExeText exeText = new ExeTextImpl();

    @Override
    public int addNode(int id, String doId, String name) {
        if (doId.equals("addSub")){
            //获取这个标签同级的上一个标签的id

            return exeNodes.insertNode(new Node(id, name));
        }else if (doId.equals("addDown")){

            Node node = exeNodes.queryNodeById(id);
            exeNodes.insertNode(new Node(node.getPid(), name));
            List<Node> nodes = exeNodes.queryNodesByPid(node.getPid());
            int i = -1;
            for (int j = 0; j < nodes.size(); j++) {
                if (nodes.get(j).getId() == id){
                    i = j;
                    break;
                }
            }
            System.out.println("i = " + i);
            for (int j = 0; j < nodes.size() - 2 - i; j++) {
                changeNodeTextUp(nodes.get(nodes.size() - 1 - j).getId());
            }
            return  1;
        }else {
            Node node = exeNodes.queryNodeById(id);
            exeNodes.insertNode(new Node(node.getPid(), name));
            List<Node> nodes = exeNodes.queryNodesByPid(node.getPid());
            int i = -1;
            for (int j = 0; j < nodes.size(); j++) {
                if (nodes.get(j).getId() == id){
                    i = j;
                    break;
                }
            }
            System.out.println("i = " + i);
            for (int j = 0; j < nodes.size() - 1 - i; j++) {
                changeNodeTextUp(nodes.get(nodes.size() - 1 - j).getId());
            }
            return  1;
        }
    }

    @Override
    public List<Node> getAllNode() {
        return exeNodes.queryAllNodesIndex();
    }

    @Override
    public Text getNodeById(int id) {
        return exeText.queryTextById(id);
    }

    @Override
    public int deleteNodeById(int id) {
        deleteAllSubNode(id);
        return 1;
    }

    @Override
    public int addText(Text text) {
        return exeText.insertText(text);
    }

    @Override
    public int deleteText(int id) {
        return exeText.deleteText(id);
    }

    @Override
    public int changeNodeTextUp(int id2) {
        int id1 = -1;
        Node node = exeNodes.queryNodeById(id2);
        List<Node> nodes = exeNodes.queryNodesByPid(node.getPid());
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getId() == id2){
                break;
            }
            id1 = nodes.get(i).getId();
        }
        if (id1 != -1){
            exeNodes.updateNodeId(id1, -2);
            exeNodes.updateNodeId(id2, id1);
            exeNodes.updateNodeId(-2, id2);
            exeNodes.updateNodePid(id1, -2);
            exeNodes.updateNodePid(id2, -3);
            exeNodes.updateNodePid(-3, id1);
            exeNodes.updateNodePid(-2, id2);
            exeText.updateTextId(id1, -2);
            exeText.updateTextId(id2, id1);
            exeText.updateTextId(-2, id2);
        }
        return 0;
    }

    @Override
    public int changeNodeTextDown(int id1) {
        int id2 = -1;
        Node node = exeNodes.queryNodeById(id1);
        List<Node> nodes = exeNodes.queryNodesByPid(node.getPid());
        for (int i = nodes.size()-1; i >= 0; i--) {
            if (nodes.get(i).getId() == id1){
                break;
            }
            id2 = nodes.get(i).getId();
        }
        if (id2 != -1) {
            exeNodes.updateNodeId(id1, -2);
            exeNodes.updateNodeId(id2, id1);
            exeNodes.updateNodeId(-2, id2);
            exeNodes.updateNodePid(id1, -2);
            exeNodes.updateNodePid(id2, -3);
            exeNodes.updateNodePid(-3, id1);
            exeNodes.updateNodePid(-2, id2);
            exeText.updateTextId(id1, -2);
            exeText.updateTextId(id2, id1);
            exeText.updateTextId(-2, id2);
        }
        return 0;
    }

    @Override
    public int changeNodeTextRight(int id) {
        List<Node> nodes = exeNodes.queryNodesByPid(exeNodes.queryNodeById(id).getPid());
        if (nodes.size() == 1){
            return 0;
        }else {
            Node node = null;
            for (int i = 0; i < nodes.size(); i++) {
                if (nodes.get(i).getId() != id){
                    node = nodes.get(i);
                    break;
                }
            }
            return exeNodes.updateNodePidById(id, node.getId());
        }
    }

    @Override
    public int changeNodeTextLeft(int id) {
        Node node = exeNodes.queryNodeById(id);
        if (node.getPid() == -1){
            return 0;
        }else {
            node = exeNodes.queryNodeById(node.getPid());
            return exeNodes.updateNodePidById(id, node.getPid());
        }
    }

    private int deleteAllSubNode(int id){
        List<Node> nodes = exeNodes.queryNodesByPid(id);
        for (Node node :
                nodes) {
            deleteAllSubNode(node.getId());
        }
        exeNodes.deleteNodeById(id);
        exeText.deleteText(id);
        System.out.println("递归体执行了一次");
        return 0;
    }

}
