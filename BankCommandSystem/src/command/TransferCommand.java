package command;

import model.BankAccount;

public class TransferCommand implements Command {

    private BankAccount sourceAccount;
    private BankAccount targetAccount;
    private double amount;

    public TransferCommand(
            BankAccount sourceAccount,
            BankAccount targetAccount,
            double amount) {

        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
    }

    @Override
    public void execute() {
        sourceAccount.transferTo(targetAccount, amount);
    }

    @Override
    public void undo() {
        targetAccount.transferTo(sourceAccount, amount);
    }

}