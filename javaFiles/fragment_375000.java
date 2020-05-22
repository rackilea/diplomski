while(input <= 5 )
    {
        String password = new2.nextLine();
        if(!password.equals("bluesky123")){
            System.out.println("Incorrect password");
            input++;
        }
        else {
            System.out.println("You got it right!");
            break;
        }

        if((input == 5) && (!password.equals("bluesky123"))) {
            System.out.println("maximum number of attempts reached");
            break;
        }
    }