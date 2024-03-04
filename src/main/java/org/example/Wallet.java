package org.example;

import java.util.ArrayList;

public class Wallet {
    private String owner;
    double uangCash;
    ArrayList<String> listKartu;

    public Wallet(String owner, int uangCash, ArrayList<String> listKartu){
        this.owner = owner;
        this.uangCash = uangCash;
        this.listKartu = listKartu;
    }

    public void withdraw(double amount){
        if(this.uangCash < amount){
            throw new Error("Uang tidak menckupi");
        }
        this.uangCash = this.uangCash - amount;
    }

    public void deposit(double amount){
        this.uangCash = this.uangCash + amount;
    }

    public void addCard(String idCard){
        this.listKartu.add(idCard);
    }

    public void removeCard(String idCard){
        boolean isDeleted = this.listKartu.remove(idCard);
        if(!isDeleted){
           throw new Error("Card not found");
        }
    }
}