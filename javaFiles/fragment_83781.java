public static void countWord(String sentenceEntered, String badWord) {

    int number = sentenceEntered.indexOf(badWord, 0);
    while (number >= 0) {
        System.out.println(number);
        number = sentenceEntered.indexOf(badWord, number + badWord.length());
    }

}// end of countWord