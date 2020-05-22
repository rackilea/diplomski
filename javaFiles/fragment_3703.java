import java.util.ArrayList;
import java.util.List;

public class CommandPatternExample {
    public static void main(String[] args) {


        List<Command> commands = new ArrayList<>();
        commands.add(new GiveBoostCmmand("knight"));
        commands.add(new GiveItemCommand("sword", "knight"));

        for (int i = 0; i < 3; i++) {
            commands.get((int)(Math.random() * commands.size())).execute();
        }


    }

    public interface Command {
        void execute();
    }

    static class GiveBoostCmmand implements Command {
        private String targetName;

        public GiveBoostCmmand(String targetName) {
            this.targetName = targetName;
        }

        public void execute() {
            System.out.println("Boosting " + this.targetName);
        }
    }

    static class GiveItemCommand implements Command {

        private String itemName;
        private String targetName;

        public GiveItemCommand(String itemName, String targetName) {
            this.itemName = itemName;
            this.targetName= targetName;
        }

        public void execute() {
            System.out.println("Giving " + this.itemName + " to " + this.targetName);
        }
    }
}