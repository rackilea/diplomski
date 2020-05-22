@OutputTimeUnit(TimeUnit.SECONDS)
public class ArrayAccess
{
  static final int gapRowsize = 128, rowsize = 32, colsize = 10_000;
  static final int[][] twod = new int[colsize][],
      gap1 = new int[colsize][];
  static final int[] oned = new int[colsize*rowsize];
  static final Random r = new Random();
  static {
    for (int i = 0; i < colsize; i++) {
      twod[i] = new int[rowsize];
      gap1[i] = new int[gapRowsize];
    }
    for (int i = 0; i < rowsize*colsize; i++) oned[i] = r.nextInt();
    for (int i = 0; i < colsize; i++)
      for (int j = 0; j < rowsize; j++)
        twod[i][j] = r.nextInt();
  }

  @GenerateMicroBenchmark
  public int oned() {
    int sum = 0;
    for (int i = 0; i < rowsize*colsize; i++)
      sum += oned[i];
    return sum;
  }

  @GenerateMicroBenchmark
  public int onedIndexed() {
    int sum = 0;
    for (int i = 0; i < colsize; i++)
      for (int j = 0; j < rowsize; j++)
        sum += oned[ind(i,j)];
    return sum;
  }

  static int ind(int row, int col) { return rowsize*row+col; }

  @GenerateMicroBenchmark
  public int twod() {
    int sum = 0;
    for (int i = 0; i < colsize; i++)
      for (int j = 0; j < rowsize; j++)
        sum += twod[i][j];
    return sum;
  }

}