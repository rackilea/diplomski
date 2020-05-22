Scanner keyboard = new Scanner(System.in);

        System.out.println("What's your balance?");
        double initialBalance = keyboard.nextDouble();
        keyboard.nextLine();

        Account chase = new Account(initialBalance);

        System.out.println("; Would you like to deposit or withdraw?");
        String control = keyboard.nextLine();

        if (control .equals("deposit") ){

        System.out.println("How much would you like to deposit? " );
        double deposit = keyboard.nextDouble();
        keyboard.nextLine();