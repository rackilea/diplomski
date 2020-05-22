import java.util.Arrays;

public final class LiCalc
{

    private LiCalc()
    {

    }

    public static double[] legLength(double tLength[], double[][] rotation, double[] platformCoords, double[] baseCoords)
    {

        double[] rotatedCoords = new double[platformCoords.length];

        for (int i = 0; i < 3; i++)
        {
            double rotatedValue = 0;
            for (int j = 0; j < 3; j++)
            {
                rotatedValue += rotation[i][j] * platformCoords[i];
            }
            rotatedCoords[i] = rotatedValue;
        }

        double[] length = new double[platformCoords.length];

        for (int i = 0; i < 3; i++)
        {
            length[i] = tLength[i] + rotatedCoords[i] - baseCoords[i];
        }

        return length;

    }

    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(LiCalc.legLength(new double[]{1, 0, 0},
                new double[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } }, new double[] { 0, 1, 1 }, new double[] { 1,
                        0, 0 })));
    }
}