/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.model.Item;
import com.sg.vendingmachinespringmvc.model.Change;
import java.math.BigDecimal;
import java.util.List;


/**
 *
 * @author BMMil
 */
public interface VendingMachineServiceLayer {
    
    public Item getItemById(Integer itemId);
    
    public List<Item> getAllItems();
    
//    public BigDecimal insertMoney(BigDecimal moneyInserted);
    
    public BigDecimal getTotalMoney();
    
    public void setTotalMoney(BigDecimal inputMoney);
       
    public Item purchaseItem(Integer itemToPurchase);
    
    public Item updateItem(Item itemToUpdate);

    public Change returnChange();
    
    public void decrementFromInventory(Item item);    
    
    public Item removeItem(Item itemId);
    
    public void createItem(Item item);
    
    public boolean checkIfItemIsInStock (Item userChoice);
    
    public boolean checkForSufficientFunds(BigDecimal inputMoney, BigDecimal itemPrice);
    
    public void zeroBalance();
    
//    public BigDecimal addDollar(String dollar);
//    
//    public BigDecimal addQuarter(BigDecimal quarter);
//    
//    public BigDecimal addDime(BigDecimal dime);
//    
//    public BigDecimal addNickel(BigDecimal nickel);
    
    public BigDecimal addMoney(String moneyString);
    
    public void setItemChoice (Integer itemId);
    
    public Integer getItemChoice();

    
    
}
