package com.ignat;

import java.util.ArrayList;

public class Branch {

    private String branchName;
    private ArrayList<Customer> branchCustomers;

    public Branch(String name) {
        this.branchName=name;
        this.branchCustomers=new ArrayList<Customer>();

    }

    public ArrayList<Customer> getBranchCustomers() {
        return branchCustomers;
    }


    public String getBranchName() {
        return this.branchName;

    }

    public boolean addNewBranchCustomer(Customer newCustomer) {

        if(findCustomer(newCustomer.getName())>=0) {
            System.out.println("Customer already exists in this branch!");
            return false;
        }
        this.branchCustomers.add(newCustomer);
        return true;
    }

    public boolean addTransactionToBranchCustomer(String existingCustomer, Double amount) {
        int customerIndex=findCustomer(existingCustomer);
        if(customerIndex<0) {
            System.out.println("Could not find customer!");
            return false;
        }
        branchCustomers.get(customerIndex).addTransaction(amount);
        return true;
    }


    private int findCustomer(String customerName) {
        for(int i=0;i<this.branchCustomers.size();i++) {
            if(this.branchCustomers.get(i).getName().equals(customerName)) {
                return i;
            }
        }
        return -1;
    }

}























