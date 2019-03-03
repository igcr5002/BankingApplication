package com.ignat;

import java.util.ArrayList;


public class Customer {

    private String name;
    private ArrayList<Double> transactions;
    public Customer(String name, Double firstTransaction) {
        this.name = name;
        this.transactions=new ArrayList<Double>();
        this.transactions.add(firstTransaction);

    }

    public String getName() {
        return this.name;
    }

    public void printTransactions() {
        for(int i =0; i<this.transactions.size();i++) {
            System.out.println((i+1)+": " + this.transactions.get(i)+"$");
        }
    }

    public void addTransaction (Double amount) {
        this.transactions.add(amount);
        System.out.println("Transaction added!");

    }

}
