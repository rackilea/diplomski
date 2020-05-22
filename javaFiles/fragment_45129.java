try {
  inFile = new Scanner(new File("info.txt"));
  int quantity = new Integer(inFile.nextLine());
  // ...
} catch (FileNotFoundException e) {
  // ...
}