ByteBuffer bytes = ByteBuffer.wrap(string.getBytes(charset));
  // you must specify a charset
IntBuffer ints = bytes.asIntBuffer();
int numInts = ints.remaining();
int[] result = new int[numInts];
ints.get(result);