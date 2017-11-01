/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Item;
import java.util.List;

/**
 *
 * @author BMMil
 */
public interface ItemListDao {
    
    public Item addItem(Item item);
    
    public List<Item> getAllItems();
    
    public Item getItemById(Integer itemId);
    
    public void updateItem(Item item);
    
    public void removeItem(Integer itemId);
    
    public void decrementFromInventory(Item item);
    
}
