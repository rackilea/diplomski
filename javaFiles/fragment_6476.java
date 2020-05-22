Scanner scan = new Scanner(System.in);
Set<String> guesses=new HashSet<String>();

System.out.println("Enter a letter");
String userInput = scan.next();
if (guesses.contains(userInput)) {
    // the user repeated a guess
} else {
    guesses.add(userInput);
}