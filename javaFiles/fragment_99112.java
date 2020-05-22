while (true) {
    randomSentence();
    System.out.println(".\n\n");
    try {
        Thread.sleep(MILLISECONDS_TO_SLEEP);
    } catch (InterruptedException e) {

    }
}