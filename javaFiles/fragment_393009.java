//MAIN 
Scanner sc = new Scanner(System.in);
OOValidator val = new OOValidator(sc);
int x = val.getInt("Enter an integer:     ");
// ...
int y = val.getIntWithinRange("Enter an integer:     ", 0, 1000);

//VALIDATION CLASS
public class OOValidator {

    private Scanner sc;
    private static final String ERROR = "Error! Invalid integer value." 
                                            +  "Try again.";
    public OOValidator(Scanner sc) {
        this.sc = sc;
    }

    public int getInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                sc.nextLine();  // discard any other data entered on the line
                break;
            } else {
                System.out.println(ERROR);
                sc.nextLine();  // discard any other data entered on the line
            }
        }
        return i;
    }

    public int getIntWithinRange(String prompt, int min, int max) {
        // same logic - use directly sc which is an instance field
    }
}