/* String to split. */
    String stringToSplit = readAllBytes(filePath);
    String[] tempArray;

    /* delimiter */
    String delimiter = " ";//space if its a file contains words

    /* given string will be split by the argument delimiter provided. */
    tempArray = stringToSplit.split(delimiter);