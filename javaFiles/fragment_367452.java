String data = "";
try {
    // input file has all data on one line, for loop isn't necessary here
    // input file has elements separated by comma characters
    for(String s : Files.readAllLines(Paths.get(inputFilename))){
        data = data + s;
    }
    String[] separated = data.split(",");// does not handle embedded commas well
    data = "";
    // output file should have each comma separated value on its own line
    for (String t : separated) {
        data = data + t + System.getProperty("line.separator");
    }
    Files.write(Paths.get(outputFilename), data.getBytes());
}