RollDice p1 = new RollDice(), p2 = new RollDice(), p3 = new RollDice(), p4 = new RollDice();
RollDice[] players = new RollDice[] { p1, p2, p3, p4 };

for (int a = 0; a < 4; a++) {
    int roll = 0;
    for (int b = 0; b < 4; b++) {
        roll = (int) Math.round(Math.random() * 5);
        roll++;
        players[a].numbers[b] = roll;
        System.out.println("You have rolled a: " + roll);
    }
    System.out.println(Arrays.toString(players[a].numbers));
}

class RollDice{
    public int [] numbers = new int [4];
}