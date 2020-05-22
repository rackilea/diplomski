File inFile = new File("infilepath.txt");
File outFile = new File("outfilepath.txt");

Scanner scanner = new Scanner(inFile);
PrintWriter out = new PrintWriter(outFile);

while (scanner.hasNext()){
    1. read input
    2. check if input is = to 42; if so, break
    3. if not print to outFile
}