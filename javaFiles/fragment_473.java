public static void main(String[] args) { // Variables
        Scanner userDed = new Scanner(System.in);
        String userChoice = "Y";
        while (userChoice.equalsIgnoreCase("Y")) {
            Scanner userNum = new Scanner(System.in);
            System.out.print("Enter the test number: ");
            if (!userNum.hasNextInt()) {
                System.out.println("Please enter an integer!");
            } else {
                int NumTo = userNum.nextInt();
                if (NumTo < 0)
                    System.out.println("Please enter a postive integer!");
                else
                    System.out.println(NumTo);

            }
            System.out.print("Would you like to continue? (Y/N)");
            userChoice = userDed.next();

        }
    }