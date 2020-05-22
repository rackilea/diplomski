Scanner keyboard = new Scanner(System.in);
System.out.print("Enter a number: ");
int number = keyboard.nextInt();  
keyboard.nextLine();  // **** add this to swallow EOL token
System.out.print("Last name: ");
lastName = keyboard.nextLine();