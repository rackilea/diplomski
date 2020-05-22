Scanner scanner = new Scanner(System.in);
System.out.print("Enter Player Name:");
String nickName = scanner.nextLine();
System.out.print("Enter Player Type:");
String playerType = scanner.nextLine();
Player player = new Player(nickName, playerType);