Map<String, Action> actions = new HashMap<>();
actions.put("look", new Look());
actions.put("drink", new Drink());

String command = "drink coke";

// Parse
Scanner cmdScanner = new Scanner(command);
actions.get(cmdScanner.next()).run(cmdScanner);