public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a message: ");
    String message = input.nextLine();
    byte[] messageBytes = message.getBytes();

    System.out.println("Before: " + message);
    // Display message in binary
    for (int i = 0; i < messageBytes.length; i++) {
        System.out.print(Integer.toBinaryString(messageBytes[i]) + " ");
    }
    System.out.println();

    // OR each byte by 1 as an example of bit manipulation
    for (int i = 0; i < messageBytes.length; i++) {
        messageBytes[i] |= 1;
    }

    System.out.println("After : " + new String(messageBytes));
    // Display message in binary
    for (int i = 0; i < messageBytes.length; i++) {
        System.out.print(Integer.toBinaryString(messageBytes[i]) + " ");
    }
    System.out.println();
}