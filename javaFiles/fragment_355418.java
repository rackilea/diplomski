public static int runTrial(int numDarts){
    int wins = 0;
    Random random = new Random();
    for(int i = 0; i < numDarts; i++)
    {
        double xCoordinate = random.nextDouble();
        double yCoordinate = random.nextDouble();
        double zTotal = Math.pow(xCoordinate, 2) + Math.pow(yCoordinate, 2);
        if(zTotal <= 1)
        {
            wins++;
        }
    }
    return wins;
}