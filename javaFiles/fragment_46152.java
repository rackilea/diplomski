while (scan.hasNext()) {
    int wordCount = 0;
    int numChars = 0;
    fileRead = scan.nextLine();

    // Note: I add an extra space at the end of the input sentence
    //       so that the while loop will pick up on the last word.
    if (fileRead.charAt(fileRead.length() - 1) == '.') {
        fileRead = fileRead.substring(0, fileRead.length() - 1) + " ";
    }
    else {
        fileRead = fileRead + " ";
    }
    int index = fileRead.indexOf(" ");
    do {
        String strA = fileRead.substring(0, index);
        System.out.print(strA + " ");
        fileRead = fileRead.substring(index+1, fileRead.length());
        index = fileRead.indexOf(" ");
        wordCount++;
        numChars += strA.length();
    } while (index != -1);

    // here is your computation.
    if (wordCount > 0) {
        double result = (double)numChars / wordCount;  // average length of words
        result = Math.pow(result, 2.0);                // square the average
        result = wordCount * result;                   // multiply by number of words
        System.out.println(result);                    // output this number
    }
}