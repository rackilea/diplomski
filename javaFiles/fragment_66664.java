String play=scan.nextLine();
System.out.println("My inputted value was " + play);

    if(play.equalsIgnoreCase("y")){
        System.out.println("Beginning new game...");
        Game();
    }

    if(play.equalsIgnoreCase("n")){
            System.out.println("Exiting game...");
            System.exit(1);
        }

    else{