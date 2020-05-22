public static int collectInteger(String purpose, int minimum, int maximum) {

        Scanner input = new Scanner(System.in);
        System.out.println(purpose);
        System.out.printf("\tEnter an integer between " + minimum + " and " + maximum + ": ");
        int value;
        do {    
            if(!input.hasNextInt()) {
                System.out.println("The value you enter needs to be between " + minimum + " and " + maximum + ". Please try again.");
                System.out.printf("\tEnter an integer between " + minimum + " and " + maximum + ": ");
                input.next();    //clear bad input                                                     
            }
            else {
                value = input.nextInt();
                if(value >= minimum && value <= maximum) {
                    return value;
                }
                else {
                    System.out.println("The value you enter needs to be between " + minimum + " and " + maximum + ". Please try again.");
                    System.out.printf("\tEnter an integer between " + minimum + " and " + maximum + ": ");

                }

            }

        } while(input.hasNext());
        return 0;
}