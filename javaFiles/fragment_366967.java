for (j = 0; j < 6; j++) {
    int randomNum = (int) (Math.random() * 49 + 1); // Random number created here.
    for (x = 0; x < j; x++) {
        if (lottery[x] == randomNum) // Here, code checks if same random number    generated before.
        {
            randomNum = (int) (Math.random() * 49 + 1);// If random number is same, another number generated.
        }
    }
    lottery[j] = randomNum;
}