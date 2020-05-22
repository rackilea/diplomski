public class GeometricSequence {
    public static void main(String[] args) {
        //Below method parameters - 5 = n, 1 = count (counter), res = result (Nth number in the GP.
        System.out.println(findNthNumber(5, 1, 2));

    }

    public static int findNthNumber(int n, int count, int res) {
        return ((count == n)) ? res : findNthNumber(n, count+1, res *3);
    }
}