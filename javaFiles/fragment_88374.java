private int[] a;

/**
 * Adds the specified array to our array, element by element, i.e.
 * for index i, a[i] = a[i] + b[i].  If the incoming array is
 * longer, we pad our array with 0's to match the length of b[].
 * If our array is longer, then only the first [b.length] values
 * of our array have b[] values added to them (which is the same
 * as if b[] were padded with 0's to match the length of a[]. 
 *
 * @param b the array to add, may not be null
 */
public void plus(final int[] b)
{
    assert b != null; 

    if (a.length < b.length) {
        // Expand a to match b
        // Have to move a to a larger array, no way to increase its
        // length "dynamically", i.e. in place.
        final int[] newA = new int[b.length];
        System.arraycopy(a, 0, newA, 0, a.length);
        // remaining new elements of newA default to 0
        a = newA;
    }

    for (int i = 0; i < b.length; i++)
    {
        a[i] = a[i] + b[i];
    }
}