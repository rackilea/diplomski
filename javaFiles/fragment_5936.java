public static void main(String[] args) {
    System.out.print(">");
    Scanner userInput = new Scanner(System.in);
    int inputValue = userInput.nextInt();
    while (userInput.hasNextInt()) {
        System.out.println("you just wrote: " + userInput.nextInt());
    }
    userInput.close();
}