package com.paiyuan.table2json.mapper;

import com.paiyuan.table2json.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

    List<Item> getAllItems();

    Item getProjectInfo(String projectId);
}
