public double getDouble(String prompt) {
    System.out.println(prompt);
    Scanner scan = new Scanner(System.in);
    double value = scan.nextDouble();
    scan.nextLine();
    return value;
}

public void getMenu() {
    Scanner scan = new Scanner(System.in);

    System.out.println("Welcome to 00 Calculator menu, this calculator has the following options:");
    System.out.println("1 - Add " + "\n" + "2 - Subtract" + "\n"
            + "3 - Multiply" + "\n" + "4 - Divide" + "\n"
            + "5 - Square" + "\n" + "6 - Modulus" + "\n" + "0 - Quit");
    int optionInt = scan.nextInt();
    scan.nextLine();

    double result;
    Action option = new Action();
    switch (optionInt) {
        case 0:
            System.out.println("Good bye!");
            break;
        case 1:
            result = option.addValues(
                    getDouble("Enter the first number :"),
                    getDouble("Enter the second number :")
            );
            option.displayResult(result);
            break;
        case 2:
            result = option.subtractValues(
                    getDouble("Enter the first number :"),
                    getDouble("Enter the second number :")
            );
            option.displayResult(result);
            break;
        case 3:
            result = option.multiplyValues(
                    getDouble("Enter the first number :"),
                    getDouble("Enter the second number :")
            );
            option.displayResult(result);
            break;
        case 4:
            result = option.divideValues(
                    getDouble("Enter the first number :"),
                    getDouble("Enter the second number :")
            );
            option.displayResult(result);
            break;
        case 5:
            result = option.squareValues(
                    getDouble("Enter a number :"),
            );
            option.displayResult(result);
            break;
        case 6:
            result = option.modulusValues(
                    getDouble("Enter the first number :"),
                    getDouble("Enter the second number :")
            );
            option.displayResult(result);
            break;
        default:
            System.out.println("You entered an incorrect option.  Goodbye.");
    }
}