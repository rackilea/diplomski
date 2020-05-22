private static int[] combineWithArraycopy(int[]... arrays)
{
    // Assuming the same length for all arrays!
    int length = arrays[0].length;
    int result[] = new int[arrays.length * length];
    for (int i = 0; i < arrays.length; i++)
    {
        System.arraycopy(arrays[i], 0, result, i * length, length);
    }
    return result;
}