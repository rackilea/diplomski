private static int[] pickCoins(int[] purse, int numCoins)
    {
        int[] samples = new int[numCoins];
        int maxInd = purse.length - 1;

        for (int i = 0; i < numCoins; i++)
        {
            int index = (int) (Math.random() * maxInd);
            int draw = purse[index];
            samples[i] = draw;
            // swap the already drawn sample with the one at maxInd and decrement maxInd
            purse[index] = purse[maxInd];
            purse[maxInd] = draw;
            maxInd -= 1;
        }

        return samples;
    }