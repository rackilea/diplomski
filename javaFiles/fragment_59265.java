public class Main {    
    public static void main(String[] args) {
        String[][] arr = { {"One", "Two"}, {null, "Four"}};
        OfInt rows = IntStream.range(0, arr.length).iterator();
        Arrays.stream(arr).forEach(subArr -> iterate(subArr, rows.nextInt()));
    }
    static <T> void iterate(T[] arr, int row) {
        OfInt columns = IntStream.range(0, arr.length).iterator();
        Arrays.stream(arr).forEach(elem -> iterateAction(row, columns.nextInt(), elem, elem == null));
    }
    static <T> void iterateAction(int x, int y, T elem, boolean isNull) {
        System.out.println(x+", "+y+", "+elem+", "+isNull);
    }    
}