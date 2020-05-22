int numWeight;
    try {
        numWeight = sc.nextInt();       
        ((Salad)menu[itemNum - 1]).setWeight(numWeight);

        System.out.println(menu[itemNum - 1].showOrderDetails());
        System.out.println("-------------------------------------------");
        System.out.println("Total No. of items ordered :");

        orderedItem[TtlOrderNum] = menu[itemNum - 1];
        TtlOrderNum += 1;

        Continue();
    }
    catch(InputMismatchException e) {
         System.err.println("Input must be an Integer");
    }