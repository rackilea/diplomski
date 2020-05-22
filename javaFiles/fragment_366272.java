public void fillPolygon(PDPageContentStream cs, float[] x, float[] y) throws IOException
{
    if (x.length != y.length)
    {
        throw new IllegalArgumentException("Error: some points are missing coordinate");
    }
    for (int i = 0; i < x.length; i++)
    {
        if (i == 0)
        {
            cs.moveTo(x[i], y[i]);
        }
        else
        {
            cs.lineTo(x[i], y[i]);
        }
    }
    cs.closePath();
    cs.fill();
}