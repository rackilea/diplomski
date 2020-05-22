public void getPlayerToStart() {
    Random rand = makeRandom();
    int randomNumber = rand.nextInt(2) + 1
    getPlayerToStart(randomNumber);
}

public Random makeRandom() {
    return new Random();
}