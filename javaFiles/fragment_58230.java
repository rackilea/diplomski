this.fileName = fileName;
boolean firstLine = true;

try {
    File file = new File(fileName);     // you need to create a File object
    Scanner input = new Scanner(file);  // then pass that File to the scanner
catch(FileNotFoundException ex) {
    ex.printStackTrace())
}

while (input.hasNextLine()) {
    ...
}