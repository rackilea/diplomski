public static void main(String[] args) {
    //Initializes the path function
    List<List<Integer>> allPaths = paths(4);
    System.out.println(allPaths);
  }

  /**
   * Recursively find all paths in a pyramid like node path. Depth first search.
   * <pre><code>
   * Row   Position     
   *  0        1       
   *  1       2 3     
   *  2      4 5 6    
   *  3     7 8 9 10 
   *  </code></pre>
   *  
   * @param maxDepth Total number of rows to travel down.
   * @return Collection of all the paths in their own collections.
   */
  public static List<List<Integer>> paths(int maxDepth) {
    List<List<Integer>> allPaths = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    path.add(1);
    paths(maxDepth, 1, 1, path, allPaths);
    return allPaths;
  }

  /**
   * Recursively find all paths in a pyramid like node path. Depth first search.
   *   
   * @param maxDepth Total number of rows to travel down.
   * @param currentDepth The current depth an iteration is on.
   * @param topPosition The position number above the current iteration.
   * @param currentPath The values so far along the path.
   * @param allPaths Container for all the paths when it reaches the end.
   */
  private static void paths(int maxDepth, int currentDepth, int topPosition, List<Integer> currentPath, List<List<Integer>> allPaths) {
    //You've hit the bottom so print the results
    if(currentDepth >= maxDepth) {
      allPaths.add(currentPath);
      return;
    }

    int nextDepth = currentDepth + 1;

    //Calculate position for left side branch, append it to values, and start it's branching iterations
    int leftPosition = topPosition + currentDepth;
    List<Integer> leftArray = new ArrayList<>(currentPath);
    leftArray.add(leftPosition);
    paths(maxDepth, nextDepth, leftPosition, leftArray, allPaths);

   //Calculate position for right side branch, append it to values, and start it's branching iterations
    int rightPosition = topPosition + currentDepth + 1;
    List<Integer> rightArray = new ArrayList<>(currentPath);
    rightArray.add(rightPosition);
    paths(maxDepth, nextDepth, rightPosition, rightArray, allPaths);
  }