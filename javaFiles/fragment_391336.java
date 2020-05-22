import java.util.Scanner;

public class Stairs {
  static int LIMIT = 200;
  static int DIRTY = -1;
  static int[][] cache = new int[LIMIT + 2][LIMIT + 2];

  public static void clearCache() {
    for (int i = 0; i <= LIMIT + 1; i++) {
      for (int j = 0; j <= LIMIT + 1; j++) {
        // mark cache as dirty/garbage values
        cache[i][j] = DIRTY;
      }
    }
  }

  public static int numberOfStaircases(int level, int bricks, int steps) {
    // base cases
    if (bricks < 0) return 0;
    if (bricks == 0 && steps >= 2) return 1;

    // only compute answer if we haven't already
    if (cache[level][bricks] == DIRTY) {
      int ways = 0;
      for (int nextLevel = level - 1; nextLevel > 0; nextLevel--) {
        ways += numberOfStaircases(nextLevel, bricks - nextLevel, steps + 1);
      }
      cache[level][bricks] = ways;
    }

    return cache[level][bricks];
  }

  public static int answer(int n) {
    clearCache();
    return numberOfStaircases(n + 1, n, 0);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    System.out.println(answer(n));
  }
}