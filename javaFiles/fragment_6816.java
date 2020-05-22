while (true) {

        Choice choice = null;

        while (choice == null) {
            System.out.println(Choice.promptText());
            choice = Choice.fromInput(scan.next());
        }

        String computerChoice = Choice.getRandomChoice().displayName;
 // ...