try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    int iLine = 0;
    String line;
    while ((line = br.readLine()) != null) {
        System.out.println( "Line " + iLine + " has " +
                            line.length() + " characters." );
        iLine++;
    }
} catch( IOException ioe ){
    // ...
}