public class Scalar {

    interface ScalarMethod<T, O> { O apply(T input); }

    public static<T, O> O[] scalar(T[] array, O[] result, ScalarMethod<T, O> method) {

        for ( int i=0; i < array.length; i++ ) {
            result[i] = method.apply(array[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] input = new String[] { "Hello", ", world!" };

        Integer[] result = Scalar.scalar(input, 
                                         new Integer[input.length],
                                         new ScalarMethod<String, Integer>() {
            @Override
            public Integer apply(String input) {
                System.out.println(input);
                return input.length();
            }
        });
    }

}