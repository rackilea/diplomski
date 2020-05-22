public static int[] copyOf(int[] original,
    int newLength) 
{
        if (0 < = newLength) {
            return copyOfRange(original, 0, newLength);
        }
        throw new NegativeArraySizeException();
}


public static int[] copyOfRange(int[] original,
    int start,
    int end) 
{
        if (start < = end) {
            if (original.length  >= start && 0 < = start) {
                int length = end - start;
                int copyLength = Math.min(length, original.length - start);
                int[] copy = new int[length];
                System.arraycopy(original, start, copy, 0, copyLength);
                return copy;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        throw new IllegalArgumentException();
}