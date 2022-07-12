package com.paiyuan.table2json.controller;

import com.paiyuan.table2json.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @RequestMapping(value = "/menu")
    public String itemController(@RequestParam("projectId") String projectId) {
        return itemService.processItems(projectId);
    }
}
