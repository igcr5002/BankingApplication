package com.ignat;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Branch> branches;
    private String bankName;

    public Bank(String bankName) {
        this.branches = new ArrayList<Branch>();
        this.bankName = bankName;
    }

    public boolean addBranch(String newBranchName) {
        if(findBranch(newBranchName)<0) {
            this.branches.add(new Branch(newBranchName));
            return true;
        }
        return false;
    }

    public boolean addBranchCustomer(String branchName, String customerName, double initialAmount) {
        int branchIndex = findBranch(branchName);
        if(branchIndex>=0) {
            Customer newCustomer = new Customer (customerName,initialAmount);
            return this.branches.get(branchIndex).addNewBranchCustomer(newCustomer);
        }
        System.out.println("Branch not found.");
        return false;
    }

    public void listBranchCustomers(String branchName, boolean showTransactions) {
        int branchIndex = findBranch(branchName);
        if (branchIndex>=0) {

            ArrayList<Customer> branchCustomers = this.branches.get(branchIndex).getBranchCustomers();
            if(branchCustomers.size()==0) {
                System.out.println("Branch "+ branchName + " has no customers.");
            } else {
                System.out.println("Customer details for branch "+this.branches.get(branchIndex).getBranchName()+":");
                for(int i=0;i<branchCustomers.size();i++) {
                    Customer branchCustomer = branchCustomers.get(i);
                    System.out.println("Customer" + "["+(i+1)+"] :" + branchCustomer.getName());
                    if(showTransactions) {
                        System.out.println("Transactions:");
                        branchCustomer.printTransactions();
//                    ArrayList<Double> transactions = branchCustomer.getTransactions();
//                    for (int j=0;j<transactions.size();j++) {
//                        System.out.println("["+(j+1)+"] Amount " + transactions.get(j));
//
//                    }
                    }

                }
            }
        } else {
            System.out.println("Branch does not exist!");
        }
    }

    private int findBranch(String branchName) {
        for (int i = 0; i < branches.size(); i++) {
            Branch checkedBranch = this.branches.get(i);
            if (checkedBranch.getBranchName().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }

    public void viewBranches() {
        if (this.branches.size() == 0) System.out.println("This bank has no branches.");
        else {
            System.out.println("Branches in bank " + this.bankName + ":");

            for (int i = 0; i < this.branches.size(); i++) {
                System.out.println((i + 1) + ":" + this.branches.get(i).getBranchName());
            }
        }
    }
    public boolean addCustomerTransaction(String branchName, String customer, double trans) {
        int branchIndex = findBranch(branchName);
        if(branchIndex>=0) {

            return this.branches.get(branchIndex).addTransactionToBranchCustomer(customer,trans);
         }
        System.out.println("Branch " + branchName + " not found.");
        return false;
    }


    public String getBankName() {
        return bankName;
    }
}
