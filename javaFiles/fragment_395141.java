String[] allCommands = new String[] { "start",
    "help", "hint", "look around", "take note",
    "look under bed" };
System.out.println(Arrays.toString(allCommands));
Collections.shuffle(Arrays.asList(allCommands)); // <-- shuffles allCommands
System.out.println(Arrays.toString(allCommands));