/** @see http://stackoverflow.com/questions/5528205 */
public class ArrayDequeCapacity {

    public static void main(String[] args) {
        for (int i = 1; i < 32; i++) {
            int n = (int) Math.pow(2, i) - 1;
            System.out.println(i + " " + n + " " + getCapacity(n));
        }
    }

    private static int getCapacity(int numElements) {
        int initialCapacity = numElements;
        initialCapacity |= (initialCapacity >>> 1);
        initialCapacity |= (initialCapacity >>> 2);
        initialCapacity |= (initialCapacity >>> 4);
        initialCapacity |= (initialCapacity >>> 8);
        initialCapacity |= (initialCapacity >>> 16);
        initialCapacity++;
        if (initialCapacity < 0)   // Too many elements, must back off
            initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
        return initialCapacity;
    }
}