int total;   // Sum of the two rolls. 
do {
    int dice1;   // First Dice.
    int dice2;   // Second Dice.

    dice1 = (int)(Math.random()*6) + 1;
    dice2 = (int)(Math.random()*6) + 1;
    total = dice1 + dice2;

    System.out.println("Your first roll is " + dice1);
    System.out.println("Your second roll is  " + dice2);
    System.out.println("Your complete roll is " + total);
} while (total != 7 && total != 12);