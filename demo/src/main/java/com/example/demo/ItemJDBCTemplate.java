package com.example.demo;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ItemJDBCTemplate implements ItemDAO{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    
    public void setDataSource(DataSource dataSource) {
       this.dataSource = dataSource;
       this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public List<Item> listItems() {
       String SQL = "select * from 'sys', 'gaming_peripherals'";
       List <Item> items = jdbcTemplateObject.query(SQL, new ItemMapper());
       return items;
    }
}
