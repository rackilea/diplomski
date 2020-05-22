private static String[][] applyFileDataToArray(String filePath, String[][] myArray) {
    // declare and intialize a String variable to hold string 
    // data lines read from file.
    String line = "";
    // Declare and initialize a temporary 2D Array to fill with file data
    // and return.
    String[][] tmpArray = new String[myArray.length][myArray[0].length];
    // Declare and iniialize a Integer variable to be used as a incremental
    // index counter for our temporary 2D Array.
    int cnt = 0;
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        // Read in each line of the data text file so as to place each
        // line of data into the a temporary 2D String Array which will
        // be ulimately returned...
        while((line = br.readLine()) != null){
            // Skip past blank lines in the text file and only process file lines
            // which actually contain data.
            if (!line.equals("")) { 
                // Each line of data within the data text file consists
                // of a string with 5 data chunks each delimited with a 
                // whitespace. We place each data chunk into a String 
                // Array and then interate through this array and place 
                // each element into the 2D Array.
                String[] tok = line.split(" ");
                for (int i = 0; i < tok.length; i++) {
                    tmpArray[cnt][i] = tok[i];
                }
                // increment index counter...
                cnt++;
            }
        }
        // Data now acquired from file - Close the BufferReader
        br.close();
    } 
    // Trap IO Exceptions from the Bufferreader if any...
    catch (IOException ex) {
        System.out.println("\n\u001B[31mThe supplied data file could"
                         + " not be found!\n\u001B[39;49m" + filePath);
    }
    // Return filled 2D Array
    return tmpArray;
}