do {
    if (command.equalsIgnoreCase("new")) {/*do new stuff*/} 
    else if (command.equalsIgnoreCase("load")) {/*do load stuff*/}
    else if (command.equalsIgnoreCase("exit")) {/*do exit stuff*/}
    else {/*do default/bad input stuff*/}

    //This line runs every loop iteration(unless one of your if blocks calls break or exit
    command = text.nextLine();
} while (!command.equalsIgnoreCase("exit"));