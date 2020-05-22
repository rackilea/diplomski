public static void readAndWrite() {
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;

    FileOutputStream outputStream = null;
    PrintWriter printWriter = null;

    String InputFileName, OutputFileName;
    String nextLine;

    clrscr();

    // Prompt user for input filename
    System.out.println("Please enter the name of the file that is to be READ (e.g. aFile.txt: ");
    InputFileName = Genio.getString();

    // Prompt user for output filename
    System.out.println("Please enter the name of the file that is to be WRITTEN (e.g. bFile.txt: ");
    OutputFileName = Genio.getString();

    try {
        // Open input file
        fileReader = new FileReader(InputFileName);
        bufferedReader = new BufferedReader(fileReader); 


        // Open output file
        outputStream = new FileOutputStream(OutputFileName);
        printWriter = new PrintWriter(outputStream);


        // Read a line
        nextLine = bufferedReader.readLine();

        // While there are lines in the input file
        while (nextLine != null) {
            // Print it to screen
            System.out.println(nextLine);

            // Write it to the output file + a new-line
            printWriter.write(nextLine+"\n");


            // Read a line
            nextLine = bufferedReader.readLine();
        }

        // Close the input file
        bufferedReader.close();

        // Close the output file
        printWriter.close();

    } catch (IOException e) {
        System.out.println("Sorry, there has been a problem opening or reading from the file");
        e.printStackTrace();
    } finally {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();    
            } catch (IOException e) {
                System.out.println("An error occurred when attempting to close the file");
            }
        }
        if(printWriter != null) {
            printWriter.close();
        }
    }
}