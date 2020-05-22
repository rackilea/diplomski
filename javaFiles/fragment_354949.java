boolean finished = false;
do {
    System.out.println("Would you like to roll again");
    start = quest.nextInt();
    if (start == 1) {
        x.roll();
        z.roll();
        total += 2; //EDIT: Rolled again, so ingrement by 2 again
        System.out.println("You roll: "+ z.getEyes() + " " + x.getEyes());
    } else {
        finished = true;
    }
} while(z.getEyes() != 1 && x.getEyes() != 1 && !finished);