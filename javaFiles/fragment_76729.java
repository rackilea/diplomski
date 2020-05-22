File file = new File(inputFileName);
try {
    Scanner sc = new Scanner(file);
    while (sc.hasNextLine()) {
        // the rest of your code here
    }
    sc.close();
} 
catch (FileNotFoundException e) {
    e.printStackTrace();
}