Scanner fileInput = null;
do {
    System.out.println("Enter file name :"); 
    try {
      fileInput = new Scanner(new File(userInput.nextLine()));
    } catch (FileNotFoundException e) {
      System.out.println("Error - file not found!");
   }
} while(fileInput == null);