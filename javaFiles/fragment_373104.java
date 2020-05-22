import java.util.ArrayList;
static ArrayList < Double > numbers = new ArrayList < Double > ();

  public static void letUserChooseAgain ()
  {
    System.out.println ("Please choose an option (1/2):");
    System.out.println ("1. Dollars to Pounds");
    System.out.println ("2. Pounds to Dollars");
    Scanner scanner = new Scanner (System.in);
    double userChoice = scanner.nextDouble ();
      numbers.add (userChoice);
      userChoiceToRemember (userChoice);
  }


  public static void userChoiceToRemember (double number)
  {
    double remember = number;
    System.out.println ("Remembered User Choice :" + numbers.get (0));
  }