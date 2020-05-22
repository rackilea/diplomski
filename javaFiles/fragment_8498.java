final int DICES = 4;
    int[] diceroll = new int[DICES];
    diceroll[0] = (int) (Math.random() * 1000 % 6 + 1);
    diceroll[1] = (int) (Math.random() * 1000 % 6 + 1);
    diceroll[2] = (int) (Math.random() * 1000 % 6 + 1);
    diceroll[3] = (int) (Math.random() * 1000 % 6 + 1);
    int total = diceroll[0] + diceroll[1] + diceroll[2] + diceroll[3];
    System.out.printf("%d %d %d %d\n", diceroll[0], diceroll[1], diceroll[2], diceroll[3]);

    // finding the lowest amount
    int min = diceroll[0];
    for (int k = 0; k < DICES; k++) {
        if (diceroll[k] < min)
            min = diceroll[k];
    }
    total -= min;