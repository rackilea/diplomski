public static int add() {
        Scanner s = new Scanner(System.in);
        int counter = 0;

        System.out.println("How many numbers to add?");
        int numCount = s.nextInt();

        for(int i = 0; i < numCount; i++) {
            System.out.println("enter number");
            counter += s.nextInt();
        }

        return counter;
    }