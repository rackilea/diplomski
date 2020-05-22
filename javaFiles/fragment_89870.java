public interface Deserialiser<T> {

    T get(String content) throws IOException;

    List<T> getList(String content) throws IOException;
}