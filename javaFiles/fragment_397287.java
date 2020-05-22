private static int[] combineWithBuffer(int[]... arrays)
{
    // Assuming the same length for all arrays!
    int length = arrays[0].length;
    int result[] = new int[arrays.length * length];
    IntBuffer buffer = IntBuffer.wrap(result);
    for (int i = 0; i < arrays.length; i++)
    {
        buffer.put(arrays[i]);
    }
    return result;
}