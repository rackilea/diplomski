public static int readInt(Scanner in) {
    System.out.println("Please type in an integer");
    return in.nextInt();
}
public static String readString(Scanner in) {
    System.out.println("Please type in a string");
    return in.nextLine();
}
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Integer you type is: " + readInt(in));
    System.out.println("String you type is: " + readString(in));
}