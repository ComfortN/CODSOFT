package org.example.ATM;

import java.util.Scanner;

public class ATM {
    private double balance;
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }


    /**
     * Displays the ATM menu options to the user.
     */
    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }


    /**
     * Runs the ATM, allowing the user to interact with the ATM menu and perform
     * banking operations such as checking balance, depositing, and withdrawal.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                checkBalance();
            } else if (choice == 2) {
                System.out.print("Enter the deposit amount: ");
                double depositAmount = scanner.nextDouble();
                deposit(depositAmount);
            } else if (choice == 3) {
                System.out.print("Enter the withdrawal amount: ");
                double withdrawalAmount = scanner.nextDouble();
                withdraw(withdrawalAmount);
            } else if (choice == 4){
                exit = true;
            } else {
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the ATM.");
        scanner.close();
    }


    /**
     * Checks and displays the current balance of the account.
     */
    public void checkBalance() {
        double currentBalance = bankAccount.getBalance();
        System.out.println("Current balance: R" + currentBalance);
    }


    /**
     * Deposits the specified amount to the account and updates the
     * account's balance. Then, it displays the new balance.
     */
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: R" + amount);
        checkBalance();
    }


    /**
     * Withdraws the specified amount from the Account if there's
     * sufficient funds. If successful, it updates the account's balance and
     * displays the new balance. If there are insufficient funds, it informs the
     * user.
     */
    public void withdraw(double amount) {
        double currentBalance = bankAccount.getBalance();

        if (currentBalance >= amount) {
            currentBalance -= amount;
            bankAccount.setBalance(currentBalance);
            System.out.println("Withdrawn: R" + amount);
            checkBalance();
        } else {
            System.out.println("Insufficient funds. Current balance: R" + currentBalance);
        }
    }

    /**
     * Main method to create an instance of the ATM class and run the ATM
     * application with a user's BankAccount.
     */
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(500);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
