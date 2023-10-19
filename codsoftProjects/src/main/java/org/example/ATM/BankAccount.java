package org.example.ATM;

public class BankAccount {

    private double balance;

    /**
     * Constructs a BankAccount with the specified initial balance.
     */
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    /**
     * Retrieves the current balance of the bank account.
     */
    public double getBalance() {
        return balance;
    }


    /**
     * Sets a new balance for the bank account.
     */
    public void setBalance(double newBalance) {
        balance = newBalance;
    }
}
