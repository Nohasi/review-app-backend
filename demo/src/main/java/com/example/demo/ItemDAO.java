package com.example.demo;

import java.util.List;
import javax.sql.DataSource;

public interface ItemDAO {
   public void setDataSource(DataSource ds);
   public List<Item> listItems();  
}