scan = new Scanner(new BufferedReader(new FileReader("LogFileToBeRead.txt")));
scan.useDelimiter(Pattern.compile("(;|\\s)"));

for (int i = 0; i < tallyArraySize; i++) {
    int ref1 = scan.nextInt();
    int ref2 = scan.nextInt();

    if (IntReferenceVal1 == ref1 && 
        IntReferenceVal2 == ref2) {
       tallyArray[i]++;
    }
}