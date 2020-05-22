public static void createdChoice() throws FileNotFoundException {
  File madLibFile = new File("/Users/adanvivero/IdeaProjects/Assignment 4/src/mymadlib.txt");
  if (madLibFile.exist()) {
    Scanner inScanner = new Scanner(System.in);
    Scanner fileScanner = new Scanner(madLibFile);
    System.out.println("Input file name: " + madLibFile.getName());
    if (inScanner.hasNext()) {
      String fileAccess = inScanner.next();
      // do whatever you need e.g
      if(fileAccess.equals(madLibFile.getName())) {
        // something here
      }
    } else {
      System.out.println("No more tokens to read !");  
    }
  } else {
    System.out.println("File mymadlib.txt does not exist !");
  }
}