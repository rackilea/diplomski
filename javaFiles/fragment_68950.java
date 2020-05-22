public class Main {

    public static class List<E extends Number> {

        private E[] myE;

        public void hello(E e) {
            E[] newArray = (E[]) new Object[5];
            for (int i = 0; i < newArray.length; i++) {
                newArray[i] = e;
            }
            myE = newArray;
        }

    }

    public static <T> T[] createArray(int size) {
        return (T[]) new Object[size];
    }

    public static void main(String[] args) throws IOException {
        List<Integer> integers = new List<Integer>();
        integers.hello(5);
    }
}