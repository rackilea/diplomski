String inputFileName = "x.txt";
String outputFileName = "y.txt";

try (BufferedReader inputFile = new BufferedReader(new FileReader(inputFileName));
        PrintWriter outputFile = new PrintWriter(new FileWriter(outputFileName))) {
    String lineOfText;
    while ((lineOfText = inputFile.readLine()) != null) {
        lineOfText = lineOfText.trim();
        if (!lineOfText.isEmpty()) {
            outputFile.println(lineOfText);
        }
    }
}