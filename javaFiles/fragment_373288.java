public class BabyNames {
  public static final String NAMES_FILE_NAME = "names.txt";

  public static final int YEAR=1900;                                   
  public static final int LS=11;
  public static final int WIDTH=50;

  private final Scanner name; 

  public BabyNames(String fileName) throws FileNotFoundException {
    name = new Scanner(new File(fileName));

  }

  public static void main(String[] args) throws FileNotFoundException {
    BabyNames babyNames = new BabyNames(NAMES_FILE_NAME);
    babyNames.intro();
    babyNames.personName();
    babyNames.graph();
  }

  public void graph() {
    // ...    
  }

  public void personName() {
    // ...    
  }

  public void intro() {
    // ...    
  }

  // ...
}