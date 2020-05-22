public class ArrayAdapter<T> extends BaseAdapter ... { // T = generic type

    public ArrayAdapter(Context context, int resource, T[] objects) {
        init(context, resource, 0, Arrays.asList(objects));
    }
    ...
}