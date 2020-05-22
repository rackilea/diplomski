public static final Scanner NAME; 

static {
  // Be sure scanner is initialized even in the case of an exception
  Scanner scanner = null;

  try {
    new Scanner(new File("names.txt"));
  } catch (FileNotFoundException e) {
    e.printStackTrace();
  }
  NAME = scanner;
}