public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    System.out.println(getUserString("Write something:", scan));
    System.out.println(getUserString("Write something else:", scan));
}

private static String getUserString(String userCommand, Scanner scan) {

    System.out.println(userCommand);

    String userinput = scan.nextLine().trim();

    if (userinput.isEmpty()) {
        System.out.println("Invalid choice");
        return getUserString(userCommand, scan);
    } else {
        return userinput;
    }
}