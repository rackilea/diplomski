for (i = 0; i < lottery.length; i++) {
    System.out.print(lottery[i] + " ");
    for (x = 0; x < j; x++) {
        if (user[i] == lottery[x]) {
            counter++;
        }
    }
}