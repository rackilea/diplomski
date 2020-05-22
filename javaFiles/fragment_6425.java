public void doFile() {
    try(Scanner cin = new Scanner(aFile)) {
        // read over file
        while (cin.hasNextLine()) {
            commonLoopBody(cin);
        }
    }
}

public void doREPL() {
    // set scanner up against user input - this is the actual line
    Scanner cin = new Scanner(System.in);
    boolean continueRunning = true;

    while(continueRunning) {
        // pretty print prompt
        System.out.printf("%n$> ");
        commonLoopBody(cin);
    }
}

private void commonLoopBody(Scanner cin) {
    // this is actually a lot more complicated, but ultimately we're
    // just doing whatever the next line says
    doWhatItSays(cin.nextLine());
}