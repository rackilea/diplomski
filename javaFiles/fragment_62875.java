public long fileLinesCount(final String filePath, boolean... ignoreBlankLines) {
    boolean ignoreBlanks = false;
    long count = 0;
    if (ignoreBlankLines.length > 0) {
        ignoreBlanks = ignoreBlankLines[0];
    }
    try {
        if (ignoreBlanks) {
            count =  Files.lines(Paths.get(filePath)).filter(line -> line.length() > 0).count();
        }
        else {
            count =  Files.lines(Paths.get(filePath)).count();
        }
    }
    catch (IOException ex) { 
        ex.printStackTrace(); 
    }
    return count;
}