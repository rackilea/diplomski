public static String getLongestSentence() throws FileNotFoundException {
    String longestSentence = "";
    String currentSentence = "";    
    Scanner scan = new Scanner(new File("t1.txt"));

    while (scan.hasNext()) {

        currentSentence = getNextSentence(scan);

        if (currentSentence.length() > longestSentence.length()) {
              longestSentence = currentSentence;
        }

    } 
    scan.close();
    return longestSentence;
}

private static String getNextSentence(Scanner scan) {
    String sentence = "";
    while(scan.hasNext()){
        sentence += scan.next();
        if(sentence.contains(".")) break;
    }
    return sentence;
}