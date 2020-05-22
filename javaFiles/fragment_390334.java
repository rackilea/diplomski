public void readInt() {
    Scanner in = new Scanner(System.in);
    System.out.println("Please type in an integer");
    int length = in.nextInt();
    System.out.println("Integer you type is: " + length);
    // in.close();
}
public void readString() {
    Scanner in = new Scanner(System.in);
    System.out.println("Please type in a string");
    String s = in.nextLine();
    System.out.println("String you type is: " + s);
    // in.close();
}