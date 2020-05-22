public class Test {
public static void main(String[] args) {
    char selectPackage; //To hold Internet Package
    double hourUsage, totalCharges, addCharges; //other variables
    //Create a Scanner object for keyboard input.
    Scanner keyboard = new Scanner(System.in);
    //Prompt the user to select a Internet Package.
    System.out.print("Which package did you purchase? ( Enter the Package's letter)");
    char input = keyboard.next().charAt(0);
    selectPackage = Character.toUpperCase(input);
    System.out.print("Please select the amount of hours used.");
    hourUsage = keyboard.nextDouble();
    //Display pricing for selected package...
    switch (selectPackage) {
        case 'A':
            if (hourUsage > 10) {
                addCharges = hourUsage - 10;
                totalCharges = (addCharges * 2.0) + 9.95;
                System.out.println("You have used " + hourUsage + " hours and your total is $" + totalCharges + " per month. "); 
            }
            else {
                System.out.println("Your total is $9.95 per month.");
            }
        break;
        case 'B':
            if (hourUsage > 20 ) { 
                addCharges = hourUsage - 20;
                totalCharges = (addCharges * 1.0) + 13.95;
                System.out.println("You have used " + hourUsage + " and your total is $" + totalCharges + " per month.");
            }
            else{ 
                System.out.println("Your total is $13.95 per month.");
            } 
        break;
        case 'C':
            System.out.println("Your total is $19.95 per month.");
        break;
        default:
            System.out.println("Invalid Choice. Choice A,B,C");
    }
    /**System.out.println("Your total is $19.95 per month.");
     System.out.println("Your total is $19.95 per month.");
     **/
}
}