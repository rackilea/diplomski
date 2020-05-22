final Random r = new Random();
String matrix[][] = new String[4][4];

for (int i = 0; i < 4; ++i)
{
    for (int j = 0; j < 4; ++j)
    {
        long value = r.nextLong() >>> -50;
        value |= 1L << 50;
        matrix[i][j] = Long.toBinaryString(value).substring(1);
    }
}