int carryover = 0;
    while (a.head != null & b.head != null) {
        int sumDigits = Integer.parseInt(a.head.getItem()) + Integer.parseInt(b.head.getItem())+carryover;
        // add least significant digit of sumDigits
        sum.addToLinkList(Integer.toString(sumDigits % 10), 0);
        // remove least significant digit from sumDigit to get the new carryover
        carryover = sumDigits / 10;
        a.head = a.head.getLink();
        b.head = b.head.getLink();
    }
    if (carryover != 0) {
        // if the last carryover isn't 0 add it as most significant digit of the result
        sum.addToLinkList(Integer.toString(carryover), 0);
    }