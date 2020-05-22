ArrayList<DoubleWritable> cache = new ArrayList<DoubleWritable>();
 for (DoubleWritable aNum : values) {
    System.out.println("first iteration: " + aNum);
    DoubleWritable writable = new DoubleWritable();
    writable.set(aNum.get());
    cache.add(writable);
 }
 int size = cache.size();
 for (int i = 0; i < size; ++i) {
     System.out.println("second iteration: " + cache.get(i));
  }