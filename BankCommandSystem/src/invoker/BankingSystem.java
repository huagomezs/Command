package invoker;

import command.Command;
import java.util.Stack;

public class BankingSystem {

    private Stack<Command> history;

    public BankingSystem() {
        history = new Stack<>();
    }

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoLastCommand() {
        if (history.isEmpty()) {
            System.out.println("There are no commands to undo.");
            return;
        }

        Command command = history.pop();
        command.undo();

        System.out.println("Last command undone.");
    }

}
