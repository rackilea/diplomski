for (String s : sentences) {
    StringBuilder numOfOccurences = new StringBuilder();

    for (String word : uniqueBagOfWords) {
        int count = 0;
        for (String wordFromSentence : s.split(" ")) {
            if (wordFromSentence.equals(word)) {
                count++;
            }
        }
        numOfOccurences.append(count);
    }
    System.out.println(s + " = " + numOfOccurences);

}