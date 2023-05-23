package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ItemMapper implements RowMapper<Item>{
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setItemId(rs.getInt("item_id"));
        item.setItemName(rs.getString("item_name"));
        item.setItemImage(rs.getString("item_image"));
        item.setItemPrice(rs.getDouble("item_price"));
        item.setItemBrand(rs.getString("item_brand"));
        item.setItemButtons(rs.getInt("item_buttons"));
        item.setItemAnalog(rs.getInt("item_analog"));
        item.setCompatibleSystems(rs.getString("compatible_systems"));
        return item;
     }
}
