package com.ignat;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank myBank = new Bank("Banca Ignat");

    public static void main(String[] args) {


        boolean quit = false;
        printActions();
        while(!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 1:
                    listBankBranches();
                    break;

                case 2:
                    addNewBranch();
                    break;

                case 3:
                    listBranchCustomers();
                    break;

                case 4:
                    addNewCustomer();
                    break;

                case 5:
                    addNewCustomerTransaction();
                    break;

                case 6:
                    printActions();
                    break;
            }

        }

    }

    private static void addNewBranch() {

        System.out.println("Enter branch name: ");
        String name = scanner.nextLine();
        if(myBank.addBranch(name)) {
            System.out.println("Branch " + name + " added to " + myBank.getBankName());
        } else {
            System.out.println("Branch " + name + " already exists.");
        }
    }

    private static void listBankBranches() {
        myBank.viewBranches();
    }

    private static void listBranchCustomers() {

        System.out.println("Enter the branch's name from where you want the customers list: ");
        String branchName = scanner.nextLine();
        System.out.println("Do you want to see the transaction list for each customer? (Y/N)");
        String transaction = scanner.nextLine();
        boolean trans=false;
        if (transaction.toLowerCase().equals("y")) trans = true;
        myBank.listBranchCustomers(branchName, trans);
    }

    private static void addNewCustomer() {
        System.out.println("Enter branch where customer is added: ");
        String branchName = scanner.nextLine();
        System.out.println("Enter customer name: ");
        String customerName= scanner.nextLine();
        System.out.println("Enter first transaction: ");
        double firstTransaction = scanner.nextDouble();
        scanner.nextLine();
        if(myBank.addBranchCustomer(branchName,customerName,firstTransaction)) {
            System.out.println("Customer " + customerName + " added to branch " + branchName + ".");
        }
    }

    private static void addNewCustomerTransaction() {
        System.out.println("Enter the branch from where the customer is: ");
        String branch = scanner.nextLine();
        System.out.println("Enter the customer's name");
        String customer = scanner.nextLine();
        System.out.println("Enter transaction amount: ");
        double trans = scanner.nextDouble();
        scanner.nextLine();
        if(myBank.addCustomerTransaction(branch,customer,trans)) {
            System.out.println("Transaction added to "+ customer);
        }
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("\t0  - to exit\n" +
                "\t1  - to view branches\n" +
                "\t2  - to add a new branch\n" +
                "\t3  - to print branch's customers\n" +
                "\t4  - to add a new customer\n" +
                "\t5  - to add a new customer's transaction\n"+
                "\t6  - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }

}