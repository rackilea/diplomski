public static void main(String[] args) throws IOException {

    try (Scanner scan = new Scanner(System.in)) {

        try {
            String number = scan.next(Pattern.compile("\\d{3}"));

            int i = Integer.parseInt("" + number.charAt(0));
            int j = Integer.parseInt("" + number.charAt(1));
            int k = Integer.parseInt("" + number.charAt(2));

            if ((i + k) == j) {
                System.out.println("Lucky Number");
            } else {
                System.out.println("Not A Lucky Number");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
        }
    }
}