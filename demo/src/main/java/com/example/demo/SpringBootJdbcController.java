package com.example.demo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "*, http://localhost:3000")
public class SpringBootJdbcController {
    @Autowired
    JdbcTemplate jdbc;
    

    @RequestMapping(path="/addreview", method=RequestMethod.POST)
    public String addReview(@RequestBody String request) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode extractedData = mapper.readTree(request);
        String userName = extractedData.get("name").asText();
        String itemId = extractedData.get("itemId").asText();
        String reviewScore = extractedData.get("returnedRating").asText();
        String reviewDetails = extractedData.get("description").asText();
        jdbc.execute("INSERT INTO `sys`.`review_peripherals` (`user_name`, `item_id`, `review_score`, `review_details`) VALUES ('"+userName+"', '"+itemId+"', '"+reviewScore+"', '"+reviewDetails+"');        ");
        return "Data inserted successfully";
    }

    @RequestMapping(path="/getitems", method=RequestMethod.GET)
    public List<Item> getItems() throws IOException{
        List<Item> items = jdbc.query("select * from gaming_peripherals", new ItemMapper());
        return items;
    }

    @RequestMapping(path="/getreviews", method=RequestMethod.GET)
    public List<Review> getReviews(@RequestParam String itemId) throws IOException{
        List<Review> reviews = jdbc.query("select * from review_peripherals where item_id = "+ itemId +"", new ReviewMapper());
        return reviews;
    }

}