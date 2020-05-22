public static void main(String[] args) throws Exception {


    List<String> lines = new ArrayList<String>();

    BufferedReader fileReader = new BufferedReader(new FileReader("text.txt")); // Create reader with access to file
    String fileLine = fileReader.readLine(); // Read the first line
    while (fileLine != null) { // While there are still lines to read, keep reading
        lines.add(fileLine); // Store the current line
        fileLine = fileReader.readLine(); // Grab the next line
    }
    fileReader.close(); // Read all the lines, so close the read

    Collections.sort(lines);
    for(String line : lines){
        System.out.println(line);
    }

}