float[] toFloatArray(Collection<Float> collection) {
  class FloatArray {
    int size;
    float[] array;
    FloatArray() {
      this.size = 0;
      this.array = new float[10];
    }
    void add(float f) {
      if (size == array.length) {
        array = Arrays.copyOf(array, array.length * 2);
      }
      array[size++] = f;
    }
    FloatArray combine(FloatArray other) {
      float[] resultArray = new float[array.length + other.array.length];
      System.arraycopy(this.array, 0, resultArray, 0, size);
      System.arraycopy(other.array, 0, resultArray, size, other.size);
      this.array = resultArray;
      this.size += other.size;
      return this;
    }
    float[] result() {
      return Arrays.copyOf(array, size);
    }
  }
  return collection.stream().collect(
     Collector.of(
         FloatArray::new, FloatArray::add, 
         FloatArray::combine, FloatArray::result));
}