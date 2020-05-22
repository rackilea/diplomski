do{
        System.out.println("");
        System.out.println("Please choose from the following options. " );
        System.out.println("");
        System.out.println("1. Do you want to use the default rotor settings?  ");
        System.out.println("2. Do you want to use the custom rotor settings?  ");
        System.out.println("3. Start over. ");
        System.out.println("");

         try {
           menuOneAnwser = Integer.parseInt(input);
        } catch (NumberFormatException e) {
        menuOneAnwser = -1;
        }


    }while(menuOneAnwser < 0 || menuOneAnwser > 3);