public static int[] randomExperiment(int max, int iters)
{
    Random randomGenerator = new Random();
    int[] counts = new int [max];
    for(int i = 0; i < iters; i++)
    {
        int randomInt = randomGenerator.nextInt(max);
        counts[randomInt]++;
    }
    return counts;
}