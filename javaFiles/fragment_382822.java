public interface MyStream<T> {
    Stream<T> stream();
}
class Util {
    static <T> MyStream<T> of(Stream<T> stream) {
        return new MyStream<>() {
            Stream<T> stream() {
                return stream;
            }
        };
    }
}