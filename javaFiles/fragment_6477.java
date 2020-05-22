Scanner scan = new Scanner(System.in);
boolean[] guesses=new boolean[26];

System.out.println("Enter a letter");
String userInput = scan.next();
char c = userInput.charAt(0);
if (c >= 'a' && c <= 'z' && !guesses[c-'a']) {
    guesses[c-'a']=true;
    // this is a valid guess
} else {
    // this is an invalid guess
}