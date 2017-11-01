/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.ItemListDao;
import com.sg.vendingmachinespringmvc.model.Item;
import com.sg.vendingmachinespringmvc.model.Change;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author BMMil
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

     private ItemListDao dao;
    private BigDecimal moneyIn = new BigDecimal("0.00");
    private String message;
    private Integer selection = 0;

    public VendingMachineServiceLayerImpl(ItemListDao dao) {
        this.dao = dao;
    }


    @Override
    public Item getItemById(Integer itemId) {
        return dao.getItemById(itemId);
    }

    @Override
    public List<Item> getAllItems() {
        return dao.getAllItems();
    }

//    @Override
//    public BigDecimal insertMoney(BigDecimal moneyInserted) {
//        BigDecimal newMoney = getTotalMoney().add(moneyInserted);
//        setTotalMoney(newMoney);
//        return totalMoney;
//    }

    @Override
    public BigDecimal getTotalMoney() {

//        if (totalMoney == null) {
//            setTotalMoney(BigDecimal.ZERO);
//        }
        return moneyIn;
    }

    @Override
    public void setTotalMoney(BigDecimal inputMoney) {
        moneyIn = inputMoney;
    }

    @Override
    public Item purchaseItem(Integer itemToPurchase) {
        Item itemChoice = getItemById(itemToPurchase);
        decrementFromInventory(itemChoice);
        //Change change = returnChange(getTotalMoney().subtract(itemChoice.getItemPrice()));
        setTotalMoney(getTotalMoney().subtract(itemChoice.getItemPrice()));
        //what is change object doing? last 2 lines doing same thing? need to set a blance to $0 after change calculated
        //setTotalMoney(BigDecimal.ZERO);
        return itemChoice;
        
    }

    @Override
    public Item updateItem(Item itemToUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Change returnChange() {
        Change change = new Change();
        BigDecimal moneyInPennies = moneyIn.multiply(new BigDecimal("100"));
        Integer moneyInPenniesInt = moneyInPennies.intValueExact();
        Integer remainingPennies = moneyInPenniesInt;

        change.setCoinQ(remainingPennies / 25);
        remainingPennies = remainingPennies % 25;
        change.setCoinD(remainingPennies / 10);
        remainingPennies = remainingPennies % 10;
        change.setCoinN(remainingPennies / 5);
        remainingPennies = remainingPennies % 5;
        change.setCoinP(remainingPennies);

        moneyIn = new BigDecimal("0.00");
        
        return change;
    }

    @Override
    public void decrementFromInventory(Item item) {
       dao.decrementFromInventory(item);
    }

    @Override
    public Item removeItem(Item itemId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createItem(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkIfItemIsInStock(Item userChoice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkForSufficientFunds(BigDecimal inputMoney, BigDecimal itemPrice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void zeroBalance() {
        setTotalMoney(BigDecimal.ZERO);
    }

//    @Override
//    public BigDecimal addDollar(BigDecimal dollar) {
//        dollar = new BigDecimal(1.00);
//        BigDecimal moneyIn = getTotalMoney().add(dollar).setScale(2, BigDecimal.ROUND_HALF_UP);
//        return totalMoney;
//    }
//    @Override
//    public BigDecimal addQuarter(BigDecimal quarter) {
//        quarter = new BigDecimal(0.25);
//        BigDecimal moneyIn = getTotalMoney().add(quarter).setScale(2, BigDecimal.ROUND_HALF_UP);
//        return totalMoney;
//    }
//
//    @Override
//    public BigDecimal addDime(BigDecimal dime) {
//        dime = new BigDecimal(0.10);
//        BigDecimal moneyIn = getTotalMoney().add(dime).setScale(2, BigDecimal.ROUND_HALF_UP);
//        return totalMoney;
//    }
//
//    @Override
//    public BigDecimal addNickel(BigDecimal nickel) {
//        nickel = new BigDecimal(0.05);
//        BigDecimal moneyIn = getTotalMoney().add(nickel).setScale(2, BigDecimal.ROUND_HALF_UP);
//        return totalMoney;
//    }

    @Override
    public BigDecimal addMoney(String moneyString) {
        switch (moneyString) {
            case "Add Dollar":
                moneyIn = moneyIn.add(new BigDecimal("1.00").setScale(2));
                break;
            case "Add Quarter":
                moneyIn = moneyIn.add(new BigDecimal("0.25").setScale(2));
                break;
            case "Add Dime":
                moneyIn = moneyIn.add(new BigDecimal("0.10").setScale(2));
                break;
            case "Add Nickel":
                moneyIn = moneyIn.add(new BigDecimal("0.05").setScale(2));
                break;
            default:
                moneyIn = moneyIn;
        }
       
        return moneyIn;
        
    }

//    @Override
//    public BigDecimal addDollar(String dollar) {
//        totalMoney = totalMoney.add(new BigDecimal("1.00"));
//        return totalMoney;
//    }

    @Override
    public void setItemChoice(Integer itemId) {
        selection = itemId;
    }

    @Override
    public Integer getItemChoice() {
        return selection;
    }
}
