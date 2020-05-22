Scanner scanner = new Scanner(System.in);

String choice = scanner.next();

if(choice.equals("1")) {
    System.out.println(" you chose number 1!");
} else if(choice.equals("2")) {
    System.out.println(" you chose number 2!");
} else if(choice.equals("3")) {
    System.out.println(" you chose number 3!");
} else if(choice.equalsIgnoreCase("q")) {
    System.out.println("the game will end now!");
    System.exit(0);
}