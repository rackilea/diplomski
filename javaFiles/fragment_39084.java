public class Dummy {
    public static class Result<ValueT extends Comparable> {
        public ValueT value;
    }

    public static <ValueT extends Comparable> Result<ValueT>
        getResult(Class<? extends Result<ValueT>> ofType) {
        return null;
    }
}