/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author BMMil
 */
public class ItemListDaoInMemImpl implements ItemListDao {
    
    private Map<Integer, Item> itemsMap = new HashMap<>(); 
    
    public ItemListDaoInMemImpl() {
    
    Item i1 = new Item(1);
    i1.setItemName("Snickers");
    i1.setItemPrice(new BigDecimal("1.85"));
    i1.setInventoryCount(9);
    itemsMap.put(1, i1);
    
    Item i2 = new Item(2);
    i2.setItemName("M&Ms");
    i2.setItemPrice(new BigDecimal("1.50"));
    i2.setInventoryCount(2);
    itemsMap.put(2, i2);
    
    Item i3 = new Item(3);   
    i3.setItemName("Pringles");
    i3.setItemPrice(new BigDecimal("2.10"));
    i3.setInventoryCount(5);
    itemsMap.put(3, i3);
    
    Item i4 = new Item(4);    
    i4.setItemName("Reese's");
    i4.setItemPrice(new BigDecimal("1.85"));
    i4.setInventoryCount(4);
    itemsMap.put(4, i4);
    
     Item i5 = new Item(5);
    i5.setItemName("Pretzels");
    i5.setItemPrice(new BigDecimal("1.25"));
    i5.setInventoryCount(9);
    itemsMap.put(5, i5);
    
    Item i6 = new Item(6);
    i6.setItemName("Doritos");
    i6.setItemPrice(new BigDecimal("1.75"));
    i6.setInventoryCount(11);
    itemsMap.put(6, i6);
    
    Item i7 = new Item(7);   
    i7.setItemName("Snickers");
    i7.setItemPrice(new BigDecimal("1.85"));
    i7.setInventoryCount(7);
    itemsMap.put(7, i7);
    
    Item i8 = new Item(8);    
    i8.setItemName("Trident");
    i8.setItemPrice(new BigDecimal("1.95"));
    i8.setInventoryCount(6);
    itemsMap.put(8, i8);
    
    Item i9 = new Item(9);    
    i9.setItemName("Cheezits");
    i9.setItemPrice(new BigDecimal("1.95"));
    i9.setInventoryCount(6);
    itemsMap.put(9, i9);
    
}

    @Override
    public Item addItem(Item item) {
        Item newItem = itemsMap.put(item.getitemId(), item);
        return newItem;
    }

    @Override
    public List<Item> getAllItems() {
        return new ArrayList<>(itemsMap.values());
        
    }

    @Override
    public Item getItemById(Integer itemId) {
        return itemsMap.get(itemId);
    }

    @Override
    public void updateItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeItem(Integer itemId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void decrementFromInventory(Item item) {
        item.setInventoryCount(item.getInventoryCount()-1);
        
    }
    
}
