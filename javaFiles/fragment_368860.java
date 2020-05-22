public int psuedoMatch(int[] guess)
{
    int psuedoCount = 0;

    if (lotteryNumbers.length != guess.length)
        return 0;

    int size = lotteryNumbers.length;

    // Determine if elements contain same data, but at different indexes!

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            // Denote the inequality check i != j
            if (lotteryNumbers[i] == guess[j] && i != j)
                psuedoCount++;
        }
    }

    return psuedoCount;
}