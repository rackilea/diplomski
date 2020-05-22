do {

        System.out.println ("Please make a selection, or use 0 to end the game:");
        cChoice = randRoll.nextInt (3) + 1;
        pChoice = input.nextInt ();

        if (pChoice == choiceArray[0] || pChoice == choiceArray[1] || pChoice == choiceArray[2])
        {
            ...
            // All your normal game stuff
            ...
        }
    }while(pChoice != 0)