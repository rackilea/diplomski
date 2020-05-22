public String readFile(String file, char mode) throws IOException {
    //in = new FileInputStream(s);
    br = new BufferedReader(new FileReader(file)); //Buffered reader for reading file
    StringBuilder result = new StringBuilder();
    String line ;
    while ((line = br.readLine()) != null) {
        if (mode == 'Q' && line.charAt(0) == 'Q') {
            result.append(line).append("\n");
        }
        if (mode == 'A' && line.charAt(0) == 'A') {
            result.append(line).append("\n");
        }
    }
    return result.toString(); //return statement
}