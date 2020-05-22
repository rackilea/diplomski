public static void main(String[] args) {
    String word = "Hello";
    String wordInverted = "";

    for (int i = 0; i < word.length(); i++)
    {
        //Get the char as a substring
        String subChar = word.substring(i, i+1);

        if (Character.isUpperCase(word.charAt(i)))
        {
            subChar = subChar.toLowerCase();
        }
        else
        {
            subChar = subChar.toUpperCase();
        }

        wordInverted += subChar; //Add the newly inverted character to the inverted string
    }

    System.out.println(wordInverted);
}