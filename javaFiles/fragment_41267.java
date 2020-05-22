// English alphabet
public static final Character[] ENGLISHARR = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'N', 'O', 'P',
        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
        'l', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

// Saurian alphabet
public static final Character[] SAURIANARR = { 'U', 'R', 'S', 'T', 'O', 'V', 'W', 'X', 'A', 'Z', 'B', 'C', 'D', 'E', 'F',
        'G', 'H', 'J', 'K', 'I', 'L', 'N', 'P', 'O', 'Q', 'u', 'r', 's', 't', 'o', 'v', 'w', 'x', 'a', 'z', 'b',
        'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'i', 'l', 'n', 'p', 'o', 'q' };


public static void main(String... args) {
    String word = "Hello World";

    // String that will be used to store the word after it has been
    // translated and will be built using the for loops
    String saurianToEnglish = "";

    // For loop that loops as long as the input is Ex. "Hello World" is 11
    // characters long
    for (int i = 0; i < word.length(); i++) {           
        // indexOfYellow should store the index number for which the letter in the string was located in the array.
        int indexOfYellow = Arrays.asList(ENGLISHARR).indexOf(word.charAt(i));
        System.out.println(indexOfYellow);

        // Should Check if the character at index i is present in ENGLISHARR then it will save it to saurianToEnglish
        if (indexOfYellow != -1) {
            saurianToEnglish += SAURIANARR[indexOfYellow];

            // This is just here to see if the if statement passed
            System.out.println("saurianToEnglish PASS   " + saurianToEnglish);
        } else {
            saurianToEnglish += word.charAt(i);

            // This is just here to see if the if statement failed
            System.out.println("saurianToEnglish FAIL   " + indexOfYellow);
        }
    }

}