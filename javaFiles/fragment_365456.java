for (int i = 0; i < n; i++) { // Begin For Loop

        if (i == 0) 
            System.out.println("Enter First Number: ");

        else if (i > 0 && i < (n - 1))
            System.out.println("Enter Next Number: \n");

        else if (i == (n - 1)) 
            System.out.println("Enter Final Number: ");

        while (!input.hasNextDouble()) {
                System.out.println("Please enter a number for array data!");
                input.next();
        }
        Double D = input.nextDouble();
        anArray[i] = D;

    } // End For Loop