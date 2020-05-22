while (a.head != null & b.head != null) {
        // add carryover here
        String[] carryCheck = (Integer.valueOf(a.head.getItem()) + Integer.valueOf(b.head.getItem()+carryover) + "").split("");
        if (carryCheck.length == 2) {

            // don't add carryover here
            sum.addToLinkList((Integer.valueOf(carryCheck[1]))+"", 0);
            carryover = Integer.valueOf(carryCheck[0]);
        } else {
            //...
    }
    // TODO: add carryover as most significant digit, if != 0