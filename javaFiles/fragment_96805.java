public static String[][] create2DStringMatrixFromFile(String filename) {

    File inFile = new File(filename);
    BufferedReader reader = new BufferedReader(new FileReader(inFile)));

    String[][] map = new String[20][15];
    Arrays.fill(map, "0");

    int rowCount = 0;
    while (reader.ready()) {
        parseLine(reader.readLine(), rowCount);
        rowCount++;       

    }                                
     return map;
}


private void parseLine(final String theLine, final int theCurrentRow) {
     final char[] eachColumn = theLine.toCharArray();
     int curColumn = 0;
     for (char c : eachColumn) {
         map[theCurrentRow][curColumn] = new String(c);
         curColumn++;       
     }

 }