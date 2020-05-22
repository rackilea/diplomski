Scanner scanner = new Scanner(System.in);
    String aString = scanner.nextLine();
    switch (aString) {
    case "Ping":
        System.out.println("Pong");
        break;

    default:
        System.out.println(aString);
    }
    scanner.close();