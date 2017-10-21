package com.mtl.dao.impl;

import com.mtl.dao.ExeNodes;
import com.mtl.pojo.Node;
import com.mtl.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExeNodesImpl implements ExeNodes {


    @Override
        public int insertNode(Node node) {
        String sql = "INSERT INTO nodes VALUES (NULL, ?, ?)";
        int i = DBUtil.executeUpdate(sql, node.toArray());
        DBUtil.closeAll();
        return i;
    }

    @Override
    public List<Node> queryAllNodesIndex() {
        List<Node> list = new ArrayList<Node>();
        String sql = "SELECT * FROM nodes";
        ResultSet resultSet = DBUtil.executeQuery(sql, new Object[]{});
        try {
            while (resultSet.next()){
                list.add(new Node(resultSet.getInt("id"), resultSet.getInt("pid"),
                        resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll();

        }
        return list;
    }

    @Override
    public int deleteNodeById(int id) {
        String sql = "DELETE FROM nodes WHERE id = ?";
        return DBUtil.executeUpdate(sql, new Object[]{id});
    }

    @Override
    public List<Node> queryNodesByPid(int pid) {
        List<Node> list = new ArrayList<Node>();
        String sql = "SELECT * FROM nodes WHERE pid = ?";
        ResultSet resultSet = DBUtil.executeQuery(sql, new Object[]{pid});
        try {
            while (resultSet.next()){
                list.add(new Node(resultSet.getInt("id"), resultSet.getInt("pid"),
                        resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll();

        }
        return list;
    }

    @Override
    public Node queryNodeById(int id) {
        String sql = "SELECT * FROM nodes WHERE id = ?";
        ResultSet resultSet = DBUtil.executeQuery(sql, new Object[]{id});
        try {
            if (resultSet.next()){
                return new Node(id, resultSet.getInt("pid"),
                        resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll();

        }
        return null;
    }

    @Override
    public Node queryNodeByPerId(int perId) {
        String sql = "SELECT * FROM nodes WHERE perid = ?";
        ResultSet resultSet = DBUtil.executeQuery(sql, new Object[]{perId});
        try {
            if (resultSet.next()){
                return new Node(resultSet.getInt("id"), resultSet.getInt("pid"),
                        resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll();

        }
        return null;
    }

    @Override
    public int updateNodeId(int i, int toI) {
        String sql = "UPDATE nodes SET id = ? WHERE id = ?";
        Object[] params = new Object[]{toI, i};
        return DBUtil.executeUpdate(sql, params);
    }

    @Override
    public int updateNodePidById(int id, int toPid) {
        String sql = "UPDATE nodes SET pid = ? WHERE id = ?";
        return DBUtil.executeUpdate(sql, new Object[]{toPid, id});
    }

    @Override
    public int updateNodePid(int pid, int toPid) {
        String sql = "UPDATE nodes SET pid = ? WHERE pid = ?";
        Object[] params = new Object[]{toPid, pid};
        return DBUtil.executeUpdate(sql, params);
    }
}
