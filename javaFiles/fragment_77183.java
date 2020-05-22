public class GenClass<T> {

    GenClass(T t, List<T> list) {}

    public static void main(String[] args) {
        GenClass m = new GenClass<>(1, new ArrayList<String>());  // Doesn't compile
    }
}