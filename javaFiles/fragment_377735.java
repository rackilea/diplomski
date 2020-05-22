char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}; 
int[] values = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
Scanner kboard = new Scanner(System.in); System.out.println("Input your word.");
String choice = kboard.nextLine();
int score = 0;
for(int i = 0; i < choice.length(); i++) {
  for(int n = 0; n < 26; n++) {
    // Use charAt here instead of substring
    if(choice.charAt(i) == alphabet[n])
    {
      score += values[n];
    }
  }
}
System.out.println("The score for your word is " + score);