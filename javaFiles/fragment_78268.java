Console console = System.console();
if (console == null) {
    System.out.println("Console not active!");
    System.exit(0);
}

System.out.print("Type something, please: ");
// This won't echo anything 
char[] userInput = console.readPassword();