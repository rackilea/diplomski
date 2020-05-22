String request = s.nextLine().toLowerCase();

    if(request.equals("leave")) {
        //leave
    } else {
        boolean isItemInStock = false;

        for (int i = 0 ; i < shopItems.length ; i++) {
            if(request.equalsIgnoreCase(shopItems[i])) {
                isItemInStock = true;
                break;
            }
        }

        if(isItemInStock) {
            System.out.println("We have this item in stock! That will be " + itemPrice[i] + " gold, "
                    + "would you like to purchase this item?");
            //...
        } else {
            System.out.println("I'm sorry, we don't have any of those in stock at the moment. Would you "
                    + "like to purchase a different item?");
            //...
        }
    }