List<Action> actions = Arrays.asList(new Drink(), new Look());

String command = "drink coke";

// Parse
Scanner cmdScanner = new Scanner(command);
String cmd = cmdScanner.next();
for (Action a : actions) {
    if (a.getClass().getAnnotation(Command.class).value().equals(cmd))
        a.run(cmdScanner);
}