Scanner fileInput = null;
try {
    File textFile = new File(userInput.nextLine());
    fileInput = new Scanner(textFile);
}
catch (FileNotFoundException e) {
    System.out.println("Error - file not found!");
    System.out.println("Re-enter file name :"); 
    fileInput = new Scanner(userInput.nextLine());
}