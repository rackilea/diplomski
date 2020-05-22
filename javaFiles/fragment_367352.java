Command[] commands = {
    new Command("Create a table") {
        @Override public void execute() {
            // code to create a table
        }
    },
    new Command("List all tables") {
        @Override public void execute() {
            // code to list all tables
        }
    }
};

for (int i = 0; i < commands.length; i++) {
    System.out.println(i + ":" + command);
}

int number = getInput();

commands[number].execute();