public static int countVowels(String[] ar1) { // this method counts

    int vowelPerWord = 0;
    int totalWordsWithThreeVowels = 0;
    char[] ar2 = new char[] { 'a', 'e', 'i', 'u', 'y', 'o' };
    for (int i = 0; i < ar1.length; i++) {
        vowelPerWord = 0;
        for (int j = 0; j < ar1[i].length(); j++) {
            for (int k = 0; k < ar2.length; k++) {
                if (ar2[k] == (ar1[i].charAt(j))) {
                    vowelPerWord++;
                }
            }
        }
        if (vowelPerWord >= 3) {
            totalWordsWithThreeVowels++;
        }
    }
    return totalWordsWithThreeVowels;
}