public static String modifyGuess(char letter, String word, String result) {
    int occurrences = 0;
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < word.length(); ++i) {
        if(word.charAt(i) == letter) {
            builder.append(letter);
            occurrences++;
        } else {
            builder.append(result.charAt(i));
        }
    }
    System.out.println("\nThe character " + letter +" occurs in " + occurrences +" positions\n");
    return builder.toString();
}

public static void main(String[] args){
    String word = "GEOLOGY";
    String result = "**OLO**";

    result = modifyGuess('G', word, result);
    System.out.println(result);
    result = modifyGuess('E', word, result);
    System.out.println(result);
    result = modifyGuess('Y', word, result);
    System.out.println(result);
}//SSCCE1