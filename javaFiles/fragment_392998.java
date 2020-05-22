public class Solution extends Recursive<Solution> implements Callable<Solution> {
  @Override
  public Solution call() throws Exception {
    return new Solution();
  }
}