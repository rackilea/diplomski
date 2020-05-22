for (int y = 0; y < h; y++)
{   
    double[] realRow = new double[w];
    double[] imagRow = new double[w];

    for (int x = 0; x < w; x++)
    {
        ...
    }
    fft.fft(realRow, imagRow);
    realVals1[y] = realRow;
    imagVals1[y] = imagRow;
}