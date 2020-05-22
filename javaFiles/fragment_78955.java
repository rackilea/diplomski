public static int[] merge(int[] a, int[] b, int pos, int n)
{
    if(n > 1) //expecting a or b to have an element
        if(a.length > 0)
            if(b.length > 0)
                if(a[0] > b[0]) //a and b have elements
                {
                    c[pos] = b[0];
                    b = Arrays.copyOfRange(b, 1, b.length);
                }
                else
                {
                    c[pos] = a[0];
                    a = Arrays.copyOfRange(a, 1, a.length);
                }
            else //b has no elements, a does
            {
                c[pos] = a[0];
                a = Arrays.copyOfRange(a, 1, a.length);
            }
        else //a has no elements
            if(b.length > 0)
            {
                c[pos] = b[0];
                b = Arrays.copyOfRange(b, 1, b.length);
            }

        merge(a, b, pos + 1, n - 1);
    }

    return c;
}