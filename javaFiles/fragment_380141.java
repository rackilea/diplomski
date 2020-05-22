public class Main<T> {

    public static void main(String[] args) {
        int a = new Main().getList().get(0);       // Doesn't compile
    }

    List<Integer> getList() { return Arrays.asList(1, 2, 3); }
}