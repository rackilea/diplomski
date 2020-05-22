//OR , you can generate IntBuffer from following native method
  /*private IntBuffer makeBuffer(int[] src, int n) {
        IntBuffer dst = IntBuffer.allocate(n*n);
        for (int i = 0; i < n; i++) {
            dst.put(src[i]);
        }
        dst.rewind();
        return dst;
    }*/