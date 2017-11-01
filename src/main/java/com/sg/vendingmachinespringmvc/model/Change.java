/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

/**
 *
 * @author BMMil
 */
public class Change {
    
    private int dollarBill;
    private int coinQ;
    private int coinD;
    private int coinN;
    private int coinP;
    
   // public Change() {
   //     
   // }

    public int getDollarBill() {
        return dollarBill;
    }

    public void setDollarBill(int dollarBill) {
        this.dollarBill = dollarBill;
    }

    public int getCoinQ() {
        return coinQ;
    }

    public void setCoinQ(int coinQ) {
        this.coinQ = coinQ;
    }

    public int getCoinD() {
        return coinD;
    }

    public void setCoinD(int coinD) {
        this.coinD = coinD;
    }

    public int getCoinN() {
        return coinN;
    }

    public void setCoinN(int coinN) {
        this.coinN = coinN;
    }

    public int getCoinP() {
        return coinP;
    }

    public void setCoinP(int coinP) {
        this.coinP = coinP;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.dollarBill;
        hash = 67 * hash + this.coinQ;
        hash = 67 * hash + this.coinD;
        hash = 67 * hash + this.coinN;
        hash = 67 * hash + this.coinP;
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
        final Change other = (Change) obj;
        if (this.dollarBill != other.dollarBill) {
            return false;
        }
        if (this.coinQ != other.coinQ) {
            return false;
        }
        if (this.coinD != other.coinD) {
            return false;
        }
        if (this.coinN != other.coinN) {
            return false;
        }
        if (this.coinP != other.coinP) {
            return false;
        }
        return true;
    }
    
    
}
