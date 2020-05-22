public static double calcDiscounts(double a, double[] b) {

    double current = b[1];
    double amount = b[0];

    Scanner input = new Scanner(System.in);
    System.out.println("You may be valid for discounts. Please answer these questions :"
            + "\nDo you have any under 10's travelling with you?\nType 1 for Yes\nType 2 for no");
    if (input.nextInt() == 1) {
        System.out.println("How many under 10's will be travelling with you?");
        int under = input.nextInt();
        if (under > amount - 1) {
            System.out.println("Invalid input - there must be at least one adult travelling alongside.");
        }
        double temp = a * under;
        current -= temp;

        System.out.println("The cost of your ticket(s) is now " + current);
    }

    System.out.println("Is anybody travelling with you under 16?\nType 1 for Yes\nType 2 for no");
    if (input.nextInt() == 1) {
        System.out.println("How many under 16's will be travelling with you?");
        int sixteen = input.nextInt();
        if (sixteen > amount) {
            System.out.println("Invalid input - you don't have this many tickets.");
        } else {
            double temp = a * 0.50;
            double next = temp * sixteen;
            current -=  next;
            System.out.println("The cost of your ticket(s) is now " + current);
        }
    }

    System.out.println("Is anybody travel a student?\nType 1 for Yes\nType 2 for no");
    if (input.nextInt() == 1) {
        System.out.println("How many students will be travelling?");
        int student = input.nextInt();
        if (student > amount) {
            System.out.println("Invalid input - you don't have this many tickets.");
        } else {
            double temp = a * 0.25;
            double next = temp * student;
            current -= next;

            System.out.println("The cost of your ticket(s) is now " + current);
        }
    }

    System.out.println("Is anybody travelling over 60?\nType 1 for Yes\nType 2 for no");
    if (input.nextInt() == 1) {
        System.out.println("How many over 60's will be travelling?");
        int sixty = input.nextInt();
        if (sixty > amount) {
            System.out.println("Invalid input - you don't have this many tickets.");
        } else {
            double temp = a * 0.60;
            double next = temp * sixty;
            current -= next;

            System.out.println("The cost of your ticket(s) is now " + current);
        }
    }
    return current;
}