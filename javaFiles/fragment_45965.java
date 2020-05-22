do {
        System.out.println("\n\n          Car Sales Menu");
        System.out.println("--------------------------------------");
        System.out.println("1 - Sort vehicles by owner's Last Name");
        System.out.println("2 - Sort vehicles by vehicle Model");
        System.out.println("3 - Sort vehicles by vehicle Cost\n");
        System.out.println("4 - List All Vehicles");
        System.out.println("5 - List All Cars");
        System.out.println("6 - List American Cars Only (Formal)");
        System.out.println("7 - List Foreign Cars only (Formal)");
        System.out.println("8 - List All Trucks");
        System.out.println("9 - List All Bicycles");
        System.out.print("\nSelect a Menu Option: ");
    try {
        int input = Integer.parseInt(getInput(input.next())); // Get user input from the keyboard 


        switch (input) {
        case 1:  // do something
                 break;
        case 2:  // do something
                 break;
        ...
       }
      } catch (NumberFormatException e) { ... }

    }
    while(true); // Display the menu until the user closes the program