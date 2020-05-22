public void waitRandomTime() {
    int max = 31;

    System.out.println("Peeking a random number in a range between 0 and " + (max - 1));
    int minute = new Random().nextInt(max);
    System.out.println("Start waiting " + minute + " minutes");

    for (int i = 0; i < minute; i++) {
        System.out.println("Minute: " + i);
        waitABit(60000); // wait one minute
    }
}