boolean firstMenu = true;
    boolean secondmenu = false;
    while(firstMenu){
        [...]
        case 4: //the main menu. user can have full functionalities after logging in or registering.
            System.out.println("Welcome " + userLoggedIn.getFirstname());
            System.out.println("Please select the option by typing the option number:");
            firstMenu = false;
            secondMenu = true;
            break;
        }
        [...]
    }
    while(secondMenu){
        [Your second menu]
    }