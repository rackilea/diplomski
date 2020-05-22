public static void main(String[] args) {
    String  readline= "i have a sentence with words";
    String[] words = readline.split(" ");
    Arrays.sort(words, (a, b)->Integer.compare(b.length(), a.length()));
    // declare a variable to hold the current string length
    int currLength = -1;
    for(int i = 0; i<words.length; i++){
        if(currLength == words[i].length()){
            // if currLength is equal to current word length just append a comma and this word
            System.out.print(", "+words[i]);
        }
        else{
            // if not update currLength, jump to a new line and print new length with the current word
            currLength = words[i].length();
            System.out.println();
            System.out.print(currLength+ " - "+words[i]);                
        }
    }
}