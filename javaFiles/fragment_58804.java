public static void main(String[] args) {
    // check what size your array should be
    int numberOfLines = 0;    
    try {
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("map.txt"));  // read the file 
        lineNumberReader.skip(Long.MAX_VALUE); // jump to end of file 
        numberOfLines = lineNumberReader.getLineNumber(); // return line number at end of file
    } catch (IOException ex) {
        Logger.getLogger(YouClass.class.getName()).log(Level.SEVERE, null, ex);
    }

    // create your array
    char[][] map = new char[numberOfLines][];   // create a 2D char[][] with as many char[] as you have lines

    // read the file line by line and put it in the array
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("map.txt"))) {
        int i = 0;
        String line = bufferedReader.readLine();   // read the first line
        while (line != null) {
            map[i++] = line.toCharArray();   // convert the read line to an array and put it in your char[][]
            line = bufferedReader.readLine(); // read the next line
        }
    } catch (IOException ex) {
        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
    }
}