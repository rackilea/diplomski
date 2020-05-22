static void SmallestAndLargestSubstring(String input) {

    char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
    char[] cons = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x',
            'y', 'z' };
    char[] charArray = input.toLowerCase().toCharArray();
    int longStartIndex=0;
    int shortStartIndex=0;
    int shortEndIndex=0;
    int longEndIndex=0;
    boolean findVowel = false;
    int bestStart = 0;
    int bestEnd = 0;
    int shortest =Integer.MAX_VALUE;

    for (int i = 0; i < charArray.length; i++) {
        for (int z = 0; z < vowels.length; z++) {
            if (charArray[i] == vowels[z]) {
                if (!findVowel){
                    // if this is the first vowel we see
                    longStartIndex = i;
                    shortStartIndex=i;
                    findVowel = true;
                }
                else {
                     shortStartIndex = i;
                }
            }
        }
        for (int j = 0; j < cons.length; j++) {
            if (charArray[i] == cons[j]) { 
                if (findVowel){
                    // if we have seen any vowel, this consonant is useless
                    longEndIndex = i; // this one is always than the previous for the largest 
                    shortEndIndex = i; // we have to check if this one is better or not
                    if (shortEndIndex-shortStartIndex<shortest){
                         bestStart = shortStartIndex;
                         bestEnd = shortEndIndex;
                         shortest = shortEndIndex-shortStartIndex;
                    }
                }
            }
        }
    }
    System.out.println(input.substring(bestStart, bestEnd+1));
    System.out.println(input.substring(longStartIndex, longEndIndex+1));
}