public static double[] convertDoubles(List<Double> doubles)
{
    double[] ret = new double[doubles.size()];
    Iterator<Double> iterator = doubles.iterator();
    int i = 0;
    while(iterator.hasNext())
    {
        ret[i] = iterator.next();
        i++;
    }
    return ret;
}