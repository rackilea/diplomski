public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a message: ");
    String message = input.nextLine();

    byte[] messageBytes = message.getBytes();
    // Using OR operation (use 1 - 127)
    for (int i = 0; i < messageBytes.length; i++) {
        messageBytes[i] |= 1;
    }

    System.out.println("Before: " + message);
    System.out.println("After : " + new String(messageBytes));
}