public final class Test<T> {
  int[][] blocks = {{0,1,2},{10,11,12},{20,21,22}};
  int[][] copyOfBlocks = Arrays.copyOf(blocks, blocks.length);
  int[][] deepCopyOfBlocks = {
    Arrays.copyOf(blocks[0], blocks[0].length),
    Arrays.copyOf(blocks[1], blocks[1].length),
    Arrays.copyOf(blocks[2], blocks[2].length)
  };

  public void test() {
    System.out.println("Before");
    System.out.println("Blocks: "+Arrays.deepToString(blocks));
    System.out.println("Shallow Copy: "+Arrays.deepToString(copyOfBlocks));
    System.out.println("Deep Copy: "+Arrays.deepToString(deepCopyOfBlocks));

    // Change blocks and copy and deep copy.
    blocks[0][0] = 99;
    copyOfBlocks[0][0] = 88;
    deepCopyOfBlocks[0][0] = 77;

    System.out.println("After");
    System.out.println("Blocks: "+Arrays.deepToString(blocks));
    System.out.println("Shallow Copy: "+Arrays.deepToString(copyOfBlocks));
    System.out.println("Deep Copy: "+Arrays.deepToString(deepCopyOfBlocks));
  }

  public static void main(String[] args) throws InterruptedException {
    try {
      Test test = new Test();
      test.test();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}