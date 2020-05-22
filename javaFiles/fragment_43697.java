System.out.print("\nDo you want thick base?");
    input = keyboard.nextLine();
    choice = input.charAt(0);
    if (choice == 'y'){
        pizza.setPizzaBase(new PizzaBase("thick"));
    } else {
        //Thin base 
        System.out.print("\nDo you want thin base?");
        input = keyboard.nextLine();
        choice = input.charAt(0);
        if (choice == 'y') {
            pizza.setPizzaBase(new PizzaBase("thin"));
        }     
    }