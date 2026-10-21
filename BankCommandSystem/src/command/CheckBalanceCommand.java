package command;

import model.BankAccount;

public class CheckBalanceCommand implements Command {

    private BankAccount account;

    public CheckBalanceCommand(BankAccount account) {
        this.account = account;
    }

    @Override
    public void execute() {
        account.checkBalance();
    }

    @Override
    public void undo() {
   
    }

}