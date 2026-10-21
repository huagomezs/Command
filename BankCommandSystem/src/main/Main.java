package main;

import model.BankAccount;
import command.DepositCommand;
import command.WithdrawCommand;
import command.TransferCommand;
import command.CheckBalanceCommand;
import invoker.BankingSystem;

public class Main {

    public static void main(String[] args) {

        BankAccount account1 = new BankAccount(
                "Victor Perez", "1001", 1000.0);

        BankAccount account2 = new BankAccount(
                "Julia Solano", "1002", 500.0);

        BankingSystem bankingSystem = new BankingSystem();

        System.out.println("BANK COMMAND SYSTEM");

        System.out.println("\n1 Deposit money");
        bankingSystem.executeCommand(new DepositCommand(account1, 200.0));

        System.out.println("\n2 Withdraw money");
        bankingSystem.executeCommand(
                new WithdrawCommand(account1, 100.0));

        System.out.println("\n3 Transfer money");
        bankingSystem.executeCommand(
                new TransferCommand(account1, account2, 300.0));

        System.out.println("\n4 Check account balance");
        bankingSystem.executeCommand(
                new CheckBalanceCommand(account1));

        System.out.println("\n5 Check target account balance");
        bankingSystem.executeCommand(
                new CheckBalanceCommand(account2));

        System.out.println("\n6 Undo last command");
        bankingSystem.undoLastCommand();

        System.out.println("\n7 Final account balances");
        bankingSystem.executeCommand(
                new CheckBalanceCommand(account1));

        bankingSystem.executeCommand(
                new CheckBalanceCommand(account2));
    }

}