public static void main (String[] args){
    Scanner inputScanner = new Scanner(System.in);
    String userInput = inputScanner.nextLine();
    System.out.println("Foo: " + userInput);
    String[] userInputSplitted = userInput.split(" " );
    String fisrtPart = userInputSplitted[0];
    String secondPart = userInputSplitted[1];
    System.out.println("1st Part: " + fisrtPart);
}