public static void main(String[] args) {
    Random r = new Random();
    for (int number = 0; number <= 9; ++number) {
        int cardRandom = 1 + r.nextInt(52);
        String cardNumber = "card" + cardRandom;
        System.out.println(cardNumber);
    }
}