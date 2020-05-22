String playerInput = "";
out.print("\nWhat do you want to do? *Type 'Commands' to look through your options.*\n");
while(! playerInput.equals("Exit")){
    playerInput = userInput.nextLine();
    if (playerInput.equals("Commands")){
        out.println("\nCommands\n"
                + "(1) - Inspect\n"
                + "(2) - Explore\n"
                + "(3) - Inventory\n"
                + "Exit - Quits the game\n");
    }

    if (playerInput.equals("1")) {
        out.print("You find a box under your bed. \nDo you want to open it?  (Y/N)\n");

        String playerAnswer = userAnswer.nextLine();
        if (playerAnswer.equals("Y")) {
            out.println("Inside the box you find a photograph");
    }

    //More if statements...
}