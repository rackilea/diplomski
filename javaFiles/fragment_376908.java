public interface Block<T> {
    void apply(T input);
}

public class FunctionUtils {
    public static <T> void forEach(Iterable<? extends T> iterable,
            Block<? super T> block) {
        for (T element : iterable) {
            block.apply(element);
        }
    }

}