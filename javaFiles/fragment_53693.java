public static boolean containsVowels(String word) {
    String vowels = "aeiouy";
    if (word == null || word.length() < vowels.length())
        return false;
    int counter = 0;
    int vowelCounter = 0;
    //Loop until the whole word has been read, or all vowels found
    while(counter<word.length() && vowelCounter < vowels.length()){
        if (word.charAt(counter) == vowels.charAt(vowelCounter)){
            vowelCounter++;
        }
        counter++;
    }
    return vowelCounter == vowels.length();
}