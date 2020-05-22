while(infile.hasNext()) { // see if there's data available
    if (infile.hasNextInt()) { // see if the next token is an int
        int i = infile.nextInt(); // if so, get the int
        exam.adScore(i);//determines the count of A, B, C, D, F grades, total count, min and max
    } else {
        infile.next(); // if not an int, read and ignore the next token
    }
}