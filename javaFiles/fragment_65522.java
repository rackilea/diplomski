public static <T> T[] removeFromArray(T[] old_array,int index)
{

    T[] old_vals = old_array;
    int old_length = old_vals.Length;
    int new_length = old_length - 1;
    @SuppressWarnings("unchecked") T[] new_vals = (T[]) Array.newInstance(old_array.getClass().getComponentType(), new_length);
    System.arraycopy(old_vals, 0, new_vals, 0, index); 
    if(index + 1 != old_length)
    {
        System.arraycopy(old_vals, index+1, new_vals, index,old_length - 1 - index);
    }

    return new_vals;
}