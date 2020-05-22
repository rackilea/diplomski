public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

    boolean isContinuing = true;

    while (isContinuing) {

        calculateLoan(in);

        boolean inputIsInvalid = true;
        while (inputIsInvalid) {
            System.out.print("Would you like to calculate again (y/n): ");

            String choice = in.next();

            if ("y".equalsIgnoreCase(choice)) {
                inputIsInvalid = false;

            } else if ("n".equalsIgnoreCase(choice)) {
                inputIsInvalid = false;
                isContinuing = false;
            } else {
                System.err.print("Error: Only valid answers are Y/N. ");
            }

        }
    }
}