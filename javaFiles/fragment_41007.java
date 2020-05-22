Object[] ring = new Object[32];
int writeIndex = 0;

public void add(Object o) {
  ring[writeIndex % ring.length] = o;
  writeIndex++;
}