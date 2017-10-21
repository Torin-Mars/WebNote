package com.mtl.dao.impl;

import com.mtl.dao.ExeText;
import com.mtl.pojo.Text;
import com.mtl.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExeTextImpl implements ExeText {

    /**
     * 通过id查找Text
     * @param id
     * @return 查到的Text对象
     */
    @Override
    public Text queryTextById(int id) {
        String sql = "SELECT * FROM TEXT WHERE id = ?";
        ResultSet resultSet = DBUtil.executeQuery(sql, new Object[]{id});
        try {
            if (resultSet.next()){
                String text = resultSet.getString("text");
                String text2 = text.replace("    ", "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp");
                return new Text(id, text2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加TEXT
     * @param text
     * @return
     */
    @Override
    public int insertText(Text text) {
        String sql = "INSERT INTO TEXT VALUES (?, ?)";
        Object[] params = new Object[]{text.getId(), text.getText()};
        return DBUtil.executeUpdate(sql, params);
    }

    /**
     * 删除id为id的行
     * @param id
     * @return删除的行数
     */
    @Override
    public int deleteText(int id) {
        String sql = "DELETE FROM text WHERE id = ?";

        return DBUtil.executeUpdate(sql, new Object[]{id});
    }

    /**
     * 把id为id的行的id修改为toId
     * @param id
     * @param toId
     * @return修改的个数
     */
    @Override
    public int updateTextId(int id, int toId) {
        String sql = "UPDATE text SET id = ? WHERE id = ?";
        Object[] params = new Object[]{id, toId};
        return DBUtil.executeUpdate(sql, params);
    }
}
