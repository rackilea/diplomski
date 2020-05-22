import java.util.ArrayList;

public final class MatrixProblem {

  private final int mx;
  private final int my;

  public MatrixProblem(int N) {
    mx = N;
    my = N;
  }

  public int countAndPrint() {
    return numPathsTracing(0, 0, new ArrayList<>());
  }

  private int numPathsTracing(int x, int y, ArrayList<String> path) {
    if(x > mx || y > my)
      return 0;
    else if(x == mx && y == my) {
      StringBuilder pathString = new StringBuilder();
      for(String previous : path) {
        pathString.append(previous);
        pathString.append(" -> ");
      }
      pathString.append(pathElement(x, y));
      System.out.println(pathString);
      return 1;
    } else {
      path.add(pathElement(x, y));
      int ret = numPathsTracing(x+1, y, path) + numPathsTracing(x, y+1, path);
      path.remove(path.size() - 1);
      return ret;
    }
  }

  private static String pathElement(int x, int y) {
    return "(" + x + ", " + y + ")";
  }
}