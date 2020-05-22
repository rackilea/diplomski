while (infp.hasNextLine()) {
    int timeEntered = infp.nextInt();

    System.out.println(timeEntered);
    busy = true;

    if (timeEntered == clock) {
        itemNum = infp.nextInt();
        type = infp.next();
        itemPrice = infp.nextDouble();
    }
    infp.nextLine();
}