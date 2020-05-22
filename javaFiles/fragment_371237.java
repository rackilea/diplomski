public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String variableName;
    String status;
    boolean firstTime;

    System.out.print("This program checks the properness of a proposed Java variable name.");

    while (true) {
        System.out.print("\nEnter a variable name (q to quit): ");
        status = "Good!";
        variableName = sc.nextLine();
        if (variableName.equals("q")) {
            System.exit(0);
        }

        firstTime = true;
        for (char ch : variableName.toCharArray()) //check each character of variableName to see if it is good style
        {
            if (Character.isJavaIdentifierPart(ch)) {
                if (Character.isLetterOrDigit(ch)) {
                    if (firstTime) {
                        if (Character.isDigit(ch)) {
                            status = "Illegal";
                            break;
                        }
                        if (Character.isUpperCase(ch)) {
                            status = "Poor Style";
                            break;
                        }
                    }
                } else {
                    status = "Poor Style";
                    break;
                }
            } else {
                status = "Illegal";
                break;
            }
            firstTime = false;
        }
        System.out.println(status);
    }
}