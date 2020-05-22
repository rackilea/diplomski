private static Object[][] applyFileDataToArray(String filePath, Object[][] myArray) {
    String line = "";
    Object[][] tmpArray = new Object[myArray.length][myArray[0].length];
    int cnt = 0;
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        // Read in each line of the data text file so as to place each
        // line of data into the a temporary 2D Object Array which will
        // be ulimately returned...
        while((line = br.readLine()) != null){
            // Skip past blank lines in the text file and only process file lines
            // which actually contain data.
            if (!line.equals("")) { 
                // Each line of data within the data text file consists
                // of a string with 5 data chunks each delimited with a 
                // whitespace. We place each data chunk into a String 
                // Array and then interate through this array and place 
                // each element into the 2D Object Array with their respective
                // data type.
                String[] tok = line.split(" ");
                tmpArray[cnt][0] = tok[0];
                tmpArray[cnt][1] = cDate(tok[1], "yyyy-MM-dd");
                tmpArray[cnt][2] = tok[2];
                tmpArray[cnt][3] = tok[3];
                tmpArray[cnt][4] = Integer.valueOf(tok[4]);
                cnt++;
            }
        }
        // Close the BufferReader
        br.close();
    } 
    // Trap IO Exceptions from the Bufferreader if any...
    catch (IOException ex) {
        System.out.println("\n\u001B[31mThe supplied Translation Table file could"
                         + " not be found!\n\u001B[39;49m" + filePath);
    }
    // Return filled 2D Object Array
    return tmpArray;
}