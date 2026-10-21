package model;

public class BankAccount {

    private String accountHolder;
    private String accountNumber;
    private double balance;

    public BankAccount(
            String accountHolder,
            String accountNumber,
            double initialBalance) {

        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative.");
        }

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit amount must be positive.");
        }

        balance += amount;

        System.out.println(
                "Deposit successful: $" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Withdrawal amount must be positive.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                    "Insufficient funds.");
        }

        balance -= amount;

        System.out.println(
                "Withdrawal successful: $" + amount);
    }

    public void transferTo(
            BankAccount targetAccount,
            double amount) {

        if (targetAccount == null || targetAccount == this) {
            throw new IllegalArgumentException(
                    "Invalid target account.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Transfer amount must be positive.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                    "Insufficient funds for transfer.");
        }

        balance -= amount;
        targetAccount.balance += amount;

        System.out.println(
                "Transfer successful: $" + amount
                + " from " + accountNumber
                + " to " + targetAccount.accountNumber);
    }

    public void checkBalance() {
        System.out.println(
                "Account holder: " + accountHolder);
        System.out.println(
                "Account number: " + accountNumber);
        System.out.println(
                "Current balance: $" + balance);
    }

}