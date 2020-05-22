System.out.print("Name: ");
    String firstName = keyboard.nextLine();

    while (firstName.trim().equals("")) {
        System.out.println("Name line can't be empty!!");
        System.out.print("Name: ");
        firstName = keyboard.nextLine();
    }
    firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
    System.out.println(firstName);