package com.paiyuan.table2json.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

import java.util.ArrayList;

@JSONType(orders = {"id", "title", "parentId", "children"})
public class Item {

    private String id;

    private String title;

    @JSONField(serialize = false)
    private String parentId = "null";

    private ArrayList<Item> children = new ArrayList<>();

    public void addChildren(Item item) {
        children.add(item);
    }

    public Item(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Item(String id, String title, String parentId) {
        this.id = id;
        this.title = title;
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getParentId() {
        return parentId;
    }

    public ArrayList<Item> getChildren() {
        return children;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setChildren(ArrayList<Item> children) {
        this.children = children;
    }
}
