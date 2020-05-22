public static void main(String[] args) {
  // let's say there is no such file
  final File file  = new File("temp/foo.txt");
  try {
    Scanner scanner = new Scanner(file); // this will fail if file does not exist
    // otherwise it exist and you can do what you want
  } catch (FileNotFoundException e) {
    // and here you can handle the case when file not exist
  }
}