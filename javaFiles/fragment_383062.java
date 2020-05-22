public class Test {
    private static final CustomSparseArray<Integer> myArray;
    static {
        myArray = new CustomSparseArray<Integer>();
        myArray.append(1, 1);
        myArray.append(2, 5);
        myArray.lock();
    }
}