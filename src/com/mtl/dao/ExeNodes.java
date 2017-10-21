package com.mtl.dao;

import com.mtl.pojo.Node;

import java.util.List;

public interface ExeNodes {
    /**
     * 添加笔记
     */
    int insertNode(Node node);

    List<Node> queryAllNodesIndex();

    int deleteNodeById(int id);

    List<Node> queryNodesByPid(int pid);

    Node queryNodeById(int id);

    Node queryNodeByPerId(int perId);

    int updateNodeId(int i, int toI);

    int updateNodePid(int pid, int toPid);

    int updateNodePidById(int id, int toPid);

}
