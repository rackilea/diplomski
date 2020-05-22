public void chooseCommand() throws FileNotFoundException {
    System.out.println("Enter command: ");
    text = input.next();
    myCommand = Integer.parseInt(text);

    switch (myCommand) {
        case 1: 
            writeToFile();    //Log new person
            break;

        case 2:
        // Search for place
            break;

        case 3: 
            searchFor();    // Search for person by place
            break;

        // help
        case 4:
            showCommands();  // get a list of available commands 
            break;       

        case 5: 
            this.isRunning = false;
            break;

        default:
            System.out.println("Command not found");

    }
}