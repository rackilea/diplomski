Scanner keyboard = new Scanner(System.in);
BigInteger e = BigInteger.valueOf(761);
BigInteger m = keyboard.nextBigInteger();
keyboard.nextLine();

try (PrintWriter writer = new PrintWriter("\\\\share\\path\\to\\folder\\encyrption.txt", "UTF-8")) {
    writer.println("Message: " + m);
    writer.println("BigInteger: " + e);
}