import java.nio.IntBuffer;
int[][] distinctArrays(int[]... arrays) {
  Set<IntBuffer> set = new HashSet<>();
  for (int[] array : arrays) {
    set.add(IntBuffer.wrap(array));
  }
  int[][] result = new int[set.size()][];
  int i = 0;
  for (IntBuffer wrappedArray : set) {
     result[i++] = wrappedArray.array();
  }
  return result;
}