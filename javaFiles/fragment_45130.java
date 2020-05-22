Scanner inFile;
try {
  inFile = new Scanner(new File("info.txt"));
} catch (FileNotFoundException e) {
  System.out.println("Try Again");
  return;
}

int quantity = new Integer(inFile.nextLine());