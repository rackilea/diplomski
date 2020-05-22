public static int getValidatedInteger(int i, int j) {
            Scanner scr = new Scanner(System.in);
            int numInt = 0;

            while (numInt < i || numInt > j) {
                try {
                    System.out.print("Please input an integer between 4 and 19 inclusive: ");
                    numInt = scr.nextInt();

                    if (numInt < i || numInt > j) {
                        System.out.println("Incorrect Range!");
                    }

                } catch (InputMismatchException ex) {
                    System.out.println("Incorrect format!");
                    scr.next();

                }

            }
            scr.close();
            return numInt;
        }