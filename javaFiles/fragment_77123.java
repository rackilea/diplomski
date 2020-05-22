int[][] distinctArrays(int[]... arrays) {
  return Stream.of(arrays)
    .map(IntBuffer::wrap)
    .distinct()
    .map(IntBuffer::array)
    .toArray(int[][]::new);
 }