public void fillNodeBool(String inputName, int[] dims, bool[] src) {
  byte[] b = new byte[src.length];
  for (int i = 0; i < src.length; ++i) {
    b[i] = src[i] ? 1 : 0;
  }
  addFeed(inputName, Tensor.create(DatType.BOOL, mkDims(dims), ByteBuffer.wrap(b)));
}