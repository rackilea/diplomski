import java.util.ArrayList;

public class MyArrayList<T> extends ArrayList<T> {
    public boolean add(T element) {
        if (element != null) return super.add(element);
        return false;
    }
}