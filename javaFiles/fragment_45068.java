private static int countFileLines(String filePath) {
    try {
        int count = 0;
        try (InputStream inSt = new BufferedInputStream(new FileInputStream(filePath))) {
            byte[] c = new byte[1024];
            int readChars = 0;
            boolean NoNewLine = false;
            while ((readChars = inSt.read(c)) != -1) {
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') { ++count; }
                }
                NoNewLine = (c[readChars - 1] != '\n');
            }   
            if(NoNewLine) { ++count; }
            inSt.close();
        }
        return count;
    } 
    catch (FileNotFoundException ex) {
        System.out.println("countFileLines() Method ERROR - File Not Found!");
    } 
    catch (IOException ex) {
        System.out.println("countFileLines() Method ERROR - IO Exception Encountered\n" + ex.getMessage());
    } 
    return 0;
}