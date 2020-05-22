package test;

/**
 * Class to help build Java arrays from Matlab.
 */
public class JavaArrayBuilder {
    /**
     * Assign an array into a larger ragged array
     * @param array ragged array you're building
     * @param i index into array
     * @param subarray this gets autoboxed to int[] from Matlab
     */
    public static void assignIntArray(Object[] array, int i, int[] subarray) {
        array[i] = subarray;
    }
}