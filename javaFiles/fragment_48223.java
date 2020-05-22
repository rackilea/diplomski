public static void main(String[] args) {
    Calculate cal = new Calculate();
    Scanner input = new Scanner(System.in);
    int number1 = 0;
    int number2 = 0;
    boolean isNumber = false;

    do {
        try {
            System.out.println("enter number1 please : ");
            if (input.hasNextLine()) {
                number1 = verifyAndGetNumber(input.nextLine());
            }

            System.out.println("enter number2 please : ");
            if (input.hasNextLine()) {
                number2 = verifyAndGetNumber(input.nextLine());
            }

            isNumber = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } while (!isNumber);

    cal.setNumbers(number1, number2);
    cal.result();
    input.close();
}

private static int verifyAndGetNumber(String line) throws Exception {
    if (line.matches("\\d+")) {
        return Integer.parseInt(line);
    }
    throw new Exception("wrong number!");
}