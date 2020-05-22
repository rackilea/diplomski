public static double Larger(double[] scoresRecived)
{
    int c;
    double largestScore = 0.0;
    if (scoresRecived != null) {
        for (c = 0; c < scoredRecived.length; c++)
        {
            if (scoresRecived[c] > largestScore)
                largestScore = scoresRecived[c];
        }
    }
    return largestScore;
}