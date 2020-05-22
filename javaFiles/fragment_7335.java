class PlayerFactory {
    public Player makeFromScanner(Scanner scannerIn) {
        int number1 = scannerIn.nextInt();
        int number2 = scannerIn.nextInt();
        ...
        return new Player(number1, number2, ...);
    }

    public Player makeRandom() {
        Random rand = new Random();
        int number1 = rand.nextInt();
        ...
        return new Player(number1, number2, ...);
    }
}