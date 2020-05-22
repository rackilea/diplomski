private static void createVowelCombos(String word, int start) {
    StringBuilder sbAddWord = new StringBuilder(word);
    String[] splitWord = word.split("");
    if(start==splitWord.length)
    {
        System.out.println(word);
        return;
    }
    if (splitWord[start].matches(".*[aeiou]")) {
           // System.out.println("Split: " + splitWord[i]);
            for (int j = 0; j < 5; j++) {
                sbAddWord.setCharAt(start, vowelList.get(j).charAt(0));
                createVowelCombos(sbAddWord.toString(),start+1);
                //System.out.println(sbAddWord.toString());
            }
    }
    else
        createVowelCombos(sbAddWord.toString(),start+1);

}