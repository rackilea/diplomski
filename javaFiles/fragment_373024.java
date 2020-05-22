public static void newMethod() {

        Scanner sc = new Scanner(System.in);

        try {

            int input = sc.nextInt();

            switch (input) {
                case 1:
                    writeObscure(file);
                    printMenu();
                    newMethod();
                    break;

                case 2:
                    translateObscure(readObscure);
                    printMenu();
                    newMethod();
                    break;

                case 3:
                    printObscure();
                    printMenu();
                    newMethod();
                    break;

                case 4:
                    printTranslated();
                    printMenu();
                    newMethod();
                    break;

                case 0:
                    kill();
                    break;

                default:
                    throw new InputMismatchException();
            }

        } catch (InputMismatchException e) {
            System.out.println("You must use numbers.");
            newMethod();
        }

      sc.close();

}