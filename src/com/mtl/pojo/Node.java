package com.mtl.pojo;

public class Node {
    private int id;
    private int pid;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node() {
    }

    public Node(int pid, String name) {
        this.pid = pid;
        this.name = name;
    }

    public Node(int id, int pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    public Object[] toArray(){
        return new Object[]{pid, name};
    }
}
