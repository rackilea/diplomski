HeadPhone_WK6 hp = new HeadPhone_WK6();
    //Initialize input variable
    int Input;

    //Call scanner
    Scanner stdin = new Scanner(System.in);

    //Introduce HeadPhone helper
    System.out.print("Hi there! Let's have you try a pair of head phones "
            + "on and we'll see what you think of them! \nStart by choosing a "
            + "random pair of head phones. To do this, enter 1, 2, or 3: ");

    //Get user input for random pair of headphones
    Input = stdin.nextInt();
    System.out.println("Now give me value of plug in 1 or 2");
    int plugInState = stdin.nextInt();
    hp.setPluggedIn(plugInState);

    System.out.println("Now give me value volume (1/2/3");
    int volumeState = stdin.nextInt();
    hp.setVolume(volumeState);
    HeadPhone_WK6 bestPair = new HeadPhone_WK6(hp.getVolume(), hp.getPluggedIn(), "SONY", "BLUE");
    HeadPhone_WK6 worstPair = new HeadPhone_WK6(hp.getVolume(), hp.getPluggedIn(), "BOSE", "BLACK");
    HeadPhone_WK6 decentPair = new HeadPhone_WK6(hp.getVolume(), hp.getPluggedIn(), "RCA", "ORANGE");