public static double[] Combine(double[][] arrays)
{
    int totalLength = 0;
    for (double[] source : arrays)
    {
        totalLength += source.length;
    }
    double[] ret = new double[totalLength];
    int index = 0;
    for (double[] source : arrays)
    {
        System.arraycopy(source, 0, ret, index, source.length);
        index += source.length;
    }
    return ret;
}