package com.paiyuan.table2json.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import com.paiyuan.table2json.entity.Item;
import com.paiyuan.table2json.mapper.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemMapper itemMapper;

    public String processItems(String projectId) {

        List<Item> itemList = itemMapper.getAllItems();
        for (Item item : itemList) {
            System.out.println(item.getId() + " " + item.getTitle() + " " + item.getParentId());
        }

        HashMap<String, Item> itemMap = new HashMap<>();
        for (Item item : itemList) {
            itemMap.put(item.getId(), item);
        }

        Item root = itemMapper.getProjectInfo(projectId);
        for (Item item : itemList) {
            if (Objects.equals(item.getParentId(), "-1")) {
                root.addChildren(item);
                continue;
            }
            itemMap.get(item.getParentId()).addChildren(item);
        }

        System.out.println(JSON.toJSONString(root, JSONWriter.Feature.PrettyFormat));
        return JSON.toJSONString(root);
    }
}