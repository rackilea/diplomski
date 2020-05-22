do {
    System.out.println("Press: 1 to add a general purpose Room \n"
            + "Press: 2 to add a Computer Room \n"
            + "Press: 3 to display information about stored rooms \n"
            + "Press: 4 to display all rooms with projectors \n"
            + "Press: 5 to enter a number of attendees and display possible rooms. \n"
            + "Press: -1 to Exit");

    response = kb.nextInt();
    switch (response) 
       {
            case 1:
                there is code here-
            case 3:
                there is code here-
            case 4:
                there is code here-
            case 5:
                there is code here-
            case 6:
                there is code here-
            case -1:
                System.out.println("Exiting program");
                break;
            default:
                System.out.println("Not understood. Re-enter");
                break;
        }

    }while (response != -1);