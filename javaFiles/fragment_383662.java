public class DataHolder<T> {
    public List<T> ts;
    public List<String> strings = new ArrayList<String>();
}

//...
DataHolder holder = new DataHolder();
holder.strings.add(Integer.valueOf(42));