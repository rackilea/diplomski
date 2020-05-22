public void doFile() {
    try(Scanner cin = new Scanner(aFile)) {
        commonLoop(cin, cin::hasNextLine, ()->{});
    }
}

public void doREPL() {
    boolean continueRunning = true;
    commonLoop(new Scanner(System.in),()->continueRunning,()->System.out.printf("%n$> "));
}

private void commonLoop(Scanner cin, BooleanSupplier runCondition, Runnable beforeCommand){
    while(runCondition.getAsBoolean()) {
        beforeCommand.run();
        // this is actually a lot more complicated, but ultimately we're
        // just doing whatever the next line says
        doWhatItSays(cin.nextLine());
    }
}