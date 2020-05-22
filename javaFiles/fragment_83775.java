import java.util.Iterator;

public class ArrayOfInt implements Iterable<Integer>{
    private final int[] array;

    public ArrayOfInt(int size) {
        array=new int[size];
    }

    public int length() {
        return array.length;
    }

    public int get(int index) {
        return array[index];
    }

    public void put(int index, int value) {
        array[index]=value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator() {
            private int current_index;

            @Override
            public boolean hasNext() {
                return current_index<array.length;
            }

            @Override
            public Integer next() {
                return array[current_index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Cannot Resize Underlying Array");
            }
        };
    }
}