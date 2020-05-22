public interface Stateful<T> {
    static final String DATA_SEP = "#";
    static final String SEGMENT_SEP = "^";

    T load(String data);
    String save();
}