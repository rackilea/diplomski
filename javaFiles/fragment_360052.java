System.out.println("Please enter username: ");
Scanner scanner = new Scanner(System.in);
String username = scanner.nextLine();
if ("Bob".equals(username))
    System.out.println("yes");
else
    System.out.println("no");