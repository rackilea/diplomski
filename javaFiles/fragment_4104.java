public class Main {

    private static Map<String, Command> commands = new HashMap<String, Command>();

    private static void init() {
        Command addCommand = new AddCommand();
        commands.put(addCommand.getCommandName(), addCommand);
    }

    public static void main (String[] args) {
        init();
        if (args[0] != null) {
            Command command = commands.get(args[0]);
            if (command != null) {
                System.out.println(command.doAction());
            } else {
                System.out.println("Command not found");
            }
        }
    }