package com.mtl.pojo;

public class Text {
    private int id;
    private String text;

    public Text(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Object[] toArray(){
        return new Object[]{id, text};
    }
}
