public static void main(String[] args) {
    System.out.println("This is a simple calculator that will do basic calculations such as :"
            + "\nAddition (+)"
            + "\nMultiplication (*)"
            + "\nSubtraction (-)"
            + "\nDivision (/)");

    System.out.println();

    try (Scanner scan = new Scanner(System.in)) {
        while (true) {
            System.out.println("Enter Any positive number followed by pressing ENTER.");
            int first = scan.nextInt();

            System.out.println("Enter a valid OPERATOR (+,*,-,/) sign followed by pressing ENTER.");
            String operator = scan.next();

            while (operator.length() != 1 || !"+*-/".contains(operator)) {
                System.out.println("Please Re-enter a valid Operator (+,-*,/)");
                operator = scan.next();
            }

            scan.nextLine();
            System.out.println("Enter your Second number followed by an ENTER stroke.");
            int second = scan.nextInt();

            if ("+".equals(operator))
                System.out.println("The Resulting sum is " + (first + second));
            else if ("*".equals(operator))
                System.out.println("The Resulting mul is " + (first * second));
            else if ("-".equals(operator))
                System.out.println("The Resulting sub is " + (first - second));
            else if ("/".equals(operator))
                System.out.println("The Resulting div is " + ((double)first / second));

            System.out.println();
            System.out.println("Do you want to exit ('y' to exit)?");

            if ("y".equals(scan.next()))
                return;

            System.out.println();
        }
    }
}