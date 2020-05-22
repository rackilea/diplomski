public class Dinaminis<T> implements DArray<T> {
    private T[] array;
    private int kiek;
    private Class<T> cls;

    public Dinaminis(Class<T> cls) {
        this.cls = cls;
        array = (T[]) Array.newInstance(cls, 10);
        kiek = 0;
    }

    @Override
    public void ideti(T o) {
        if (kiek == array.length) {
            T[] temp = (T[]) Array.newInstance(cls, array.length * 2);
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
        }
        array[kiek++] = o;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("len = %d [", array.length));
        for (int i = 0; i < kiek; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}