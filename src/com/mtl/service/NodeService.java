package com.mtl.service;

import com.mtl.pojo.Node;
import com.mtl.pojo.Text;

import java.util.List;

public interface NodeService {

    /**
     * 添加一个node到nodes表中
     * @param id
     * @param doId
     * @param name
     * @return
     */
    int addNode(int id, String doId, String name);

    /**
     * 获取nodes表中的所有数据
     * @return
     */
    List<Node> getAllNode();

    /**
     * 通过id获取一个Node对象
     * @param id
     * @return
     */
    Text getNodeById(int id);

    /**
     * 通过id删除一行数据
     * @param id
     * @return
     */
    int deleteNodeById(int id);

    /**
     * 添加一个Text对象到text表中
     * @param text
     * @return
     */
    int addText(Text text);

    /**
     * 通过id
     * 删除Text表中的一行
     * @param id
     * @return
     */
    int deleteText(int id);

    /**
     * 使id为id2的标签向上同级移动一次
     * @param id2
     * @return
     */
    int changeNodeTextUp(int id2);

    /**
     * 使id为id1 的标签向下同级移动一次
     * @param id1
     * @return
     */
    int changeNodeTextDown(int id1);

    /**
     * 使id为id的标签向右移动一次， 向右的父标签是第一个不是自己的同级标签
     *
     * @param id
     * @return
     */
    int changeNodeTextRight(int id);

    /**
     * 使id为id的标签向左移动一次， 移动到和父标签同级
     * @param id
     * @return
     */
    int changeNodeTextLeft(int id);
}
