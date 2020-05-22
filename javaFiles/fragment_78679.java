for (i = 1; i < buyList[0].length; i++) {
    tempPrice = buyList[1][i] * price[buyList[0][i]];
    System.out.print(" | " + tempPrice);
    totalPrice += buyList[1][i] * price[buyList[0][i]];
    System.out.println(totalPrice);
    // count * price
}