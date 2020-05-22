private final String fileName;
private final Scanner scanner;

public FileDisplay() {
  this("default.txt");
}

public FileDisplay(String fileName) {
  this.fileName = fileName;
  this.scanner = new Scanner(new File(fileName));
}