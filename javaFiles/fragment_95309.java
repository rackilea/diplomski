int num = 0;
    //flag
    boolean inputOk = false;
    try (Scanner s = new Scanner(System.in)) {
        do {

            try {
                System.out.println("Enter a number....");
                num = s.nextInt();

                System.out.println("you entered : " + num);
                // got here then things are good
                inputOk = true;

            } catch (InputMismatchException ex) {
                System.out.println("Again please....digits only");
                // flush the scanner
                s.next();

            }
        }
        while (inputOk != true);
    }
        System.out.println("Thank you");