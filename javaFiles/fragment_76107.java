while(roll1 != roll2) {

    roll1 = 1 + dice.nextInt(6);
    roll2 = 1 + dice.nextInt(6);

    System.out.println("Die 1: " + roll1);
    System.out.println("Die 2: " + roll2);
    System.out.println("The total is " + (roll1 + roll2) + "\n");
}