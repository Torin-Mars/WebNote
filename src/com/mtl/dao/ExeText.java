package com.mtl.dao;

import com.mtl.pojo.Text;

public interface ExeText {
    Text queryTextById(int id);
    int insertText(Text text);
    int deleteText(int id);
    int updateTextId(int id, int toId);
}
