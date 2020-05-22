public class ArrayOfInt{
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

}