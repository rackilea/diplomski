int userInput;
System.out.println("Please enter an integer:");
while(true){
    try {
        userInput = Integer.parseInt(stdin.next());
        break;
    } catch (InputMismatchException e) {
        System.out.println("Please enter a valid integer:");
    }
}