package com.example.demo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "*")
public class SpringBootJdbcController {
    @Autowired
    JdbcTemplate jdbc;
    

    @RequestMapping(path="/addreview", method=RequestMethod.POST)
    public String addReview(@RequestBody String request) throws IOException{
        System.out.println(request);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode extractedData = mapper.readTree(request);
        System.out.println(extractedData.get("name").asText());
        return "Data inserted successfully";
    }

    @RequestMapping(path="/getitems", method=RequestMethod.GET)
    public List<Item> getItems() throws IOException{
        List<Item> items = jdbc.query("select * from 'sys' , 'gaming_peripherals'", new RowMapper<Item>());
        return ;
    }
}