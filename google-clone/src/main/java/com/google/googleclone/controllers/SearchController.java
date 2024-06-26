package com.google.googleclone.controllers;

import com.google.googleclone.entities.WebPage;
import com.google.googleclone.service.SearchService;
import com.google.googleclone.service.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private SpiderService spiderService;

    @CrossOrigin("*")
    @RequestMapping(value = "api/search", method = RequestMethod.GET)
    public List<WebPage> search(@RequestParam Map<String, String> params){
        String query = params.get("query");
        return searchService.search(query);
    }

    @CrossOrigin("*")
    @RequestMapping(value = "api/test", method = RequestMethod.GET)
    public void search(){
        spiderService.indexWebPages();
    }

}
