case 3: {
        System.out
                .println("You head towards Moat Caillin. the journey is swift and you are greeted by the Lord of Moat Caillin");
        System.out
                .println("The Lord of Moat Caillin offers your his company for dinner. type in your desired option");
        System.out.println("1: accept the lords offer.");
        System.out.println("2: kindly decline the lords offer.");
        System.out.println("3: kill the lord and take his possessions.");
        byte input4 = Byte.parseByte(reader.nextLine());

        switch (input4) {
        case 1:
            System.out
                    .println("the lord insults you at dinner. you lose your temper and walk out. the lord has you killed. Game over.");
            break;
        case 2:
            System.out
                    .println("the lord accepts your decline. he offers you gold to reconsider, as he has a proposition for you.");
            break;
        case 3:
            System.out
                    .println("you kill the lord, and take Moat Caillin. you marry the daughter of a highborn.");
            break;
        default:
            System.out.println("invalid input");
        }

        break;
    Default:
        System.out.println("Invalid Input");
        break;
    }