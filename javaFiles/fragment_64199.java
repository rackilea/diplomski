import java.lang.reflect.Array;

public class Example <T> {

    private final Class<? extends T> cls;

    public Example (Class<? extends T> cls) {
        this.cls = cls;
    }

    public void arrayExample () {
        // a [10][20] array
        @SuppressWarnings("unchecked")
        T[][] array = (T[][])Array.newInstance(cls, 10, 20);
        System.out.println(array.length + " " + array[0].length + " " + array.getClass());
    }

    public static final void main (String[] args) {
        new Example<Integer>(Integer.class).arrayExample();
    }

}