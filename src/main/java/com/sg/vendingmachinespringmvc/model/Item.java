/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author BMMil
 */
public class Item {

    private String itemName;
    private Integer itemId;
    private BigDecimal itemPrice;
    private Integer inventoryCount;

   public Item(Integer itemId) {
        this.itemId = itemId;
        
    }

    public Item() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getitemId() {
        return itemId;
    }

    public void setitemId(Integer itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Integer inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
    
     @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.itemName);
        hash = 59 * hash + Objects.hashCode(this.itemId);
        hash = 59 * hash + Objects.hashCode(this.itemPrice);
        hash = 59 * hash + Objects.hashCode(this.inventoryCount);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.itemId, other.itemId)) {
            return false;
        }
        if (!Objects.equals(this.itemPrice, other.itemPrice)) {
            return false;
        }
        if (!Objects.equals(this.inventoryCount, other.inventoryCount)) {
            return false;
        }
        return true;
    }
    
    
//       public Item(Integer itemId, String itemName, BigDecimal itemPrice, Integer inventoryCount) {
//       this.itemId = itemId;
//       this.itemName = itemName;
//       this.itemPrice = itemPrice;
//       this.inventoryCount = inventoryCount;
//   }
//    
    
//    public Item(String itemId, String itemName, String itemPrice, String inventoryCount) {
//       this.itemId = Integer.parseInt(itemId);
//       this.itemName = itemName;
//       this.itemPrice = new BigDecimal(itemPrice);
//       this.inventoryCount = Integer.parseInt(inventoryCount);
//   }
//    
}
