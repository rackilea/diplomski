public static void main(String[] args) throws Exception {
    double sum = 0, next ;
    int ctr = 0;
    String line;
    String filename = "numbers.txt";
    StringTokenizer st;
    PrintWriter outFile = new PrintWriter("output.txt");
    outFile.println("Output File");
    try{
        Scanner inFile = new Scanner(new FileReader(filename));
        while (inFile.hasNext())
        {
            line = inFile.nextLine();
            st = new StringTokenizer(line);
            while (st.hasMoreTokens()){
                next = Double.parseDouble(st.nextToken());
                sum += next;
                ctr++;
                System.out.println(next);
                outFile.println(next);
            }
        }
        System.out.println("number of doubles read is " + ctr);
        System.out.println("average is " + sum/(double)ctr);
        outFile.println("number of doubles read is " + ctr);
        outFile.println("average is " + sum/(double)ctr);
        outFile.flush();
        inFile.close();
        outFile.close();
    }
    catch(FileNotFoundException e){
        System.out.println("The file numbers.txt was not found");
    }
    catch(NumberFormatException e){
        System.out.println("sorry - number format error");
        System.out.println(e);
    }
}