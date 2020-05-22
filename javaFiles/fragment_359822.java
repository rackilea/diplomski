public static Player getWinner(int winningNumber, Map<Player, Integer> lotteryEntries)
{
    int cumulativeProbability = 0;
    for (Map.Entry<Player, Integer> entry : lotteryEntries.entrySet())
    {
        cumulativeProbability += entry.getValue();
        if (cumulativeProbability >= winningNumber)
        {
            return entry.getKey();
        }
    }
    throw new RuntimeException("Winning number not within total pot size");
}