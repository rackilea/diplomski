public static void main(String[] args) {
  final File file  = new File("temp/foo.txt");
  if (file.exists()) {
    System.out.printf("File " + file.getName() + " exist !");
  }
}