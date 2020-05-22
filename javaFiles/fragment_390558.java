private final TIntIntHashMap map = ...

public void putInt(int x, int y, int value) {
   int index = (x << 16) + y;
   map.put(index, value); // only uses primitives.
}

public int getInt(int x, int y) {
   int index = (x << 16) + y;
   return map.get(index);
}