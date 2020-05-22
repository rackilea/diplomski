Integer numWeight = sc.nextInt();
    if (numWeight instanceof Integer) {
        ((Salad)menu[itemNum - 1]).setWeight(numWeight);

        System.out.println(menu[itemNum - 1].showOrderDetails());
        System.out.println("-------------------------------------------");
        System.out.println("Total No. of items ordered :");

        orderedItem[TtlOrderNum] = menu[itemNum - 1];
        TtlOrderNum += 1;

        Continue();
    }
    else {
        System.out.println("input must a be integer");
    }