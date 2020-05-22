public class IntArray {
private int[] data;
private int used;
private void grow() {
 // implement code to make data double in size here...
}
public IntArray(int size) {
  data = new int[size];
  used = 0;
}

public void add(int i) {
  if (i >= data.length) grow();
  data[used++] = i;
}
}

IntArray list2 = new IntArray(1000000);
for (int i = 0; i < 1000000; i++)
  list2.add(i);