public static void runAllTrials(int numTrials, int numDarts)
{
    int totalCounter = 0;

    for(int i = 0; i < numTrials; i++)
    {
        int wins = runTrial(numDarts);
        System.out.println(
                String.format("Trial [%d]: Pi = %g ",
                        (i+1),
                        calculatePi(wins, numDarts)
                )
        );

        totalCounter += wins;

    }
    System.out.println(
            String.format("Overall: Pi = %g ",
                calculatePi(totalCounter, numDarts * numTrials)
        )
    );


}

public static double calculatePi(int wins, int darts){
    return 4*((double)wins) / darts;
}