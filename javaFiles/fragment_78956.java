int[] merge(int[] a, int[] b)
{
    return merge(a, 0, b, 0, new int[a.length + b.length], 0);
}

int[] merge(int[] a, int aCounter, int[] b, int bCounter, int[] out, int outCounter)
{
    if(aCounter < a.length && bCounter < b.length) //both arrays have elements
        if(a[aCounter] < b[bCounter])
        {
            out[outCounter] = a[aCounter];
            return merge(a, aCounter + 1, b, bCounter, out, outCounter + 1);
        }
        else
        {
            out[outCounter] = b[bCounter];
            return merge(a, aCounter, b, bCounter + 1, out, outCounter + 1);
        }

    if(aCounter < a.length) //only a has elements
    {
        out[outCounter] = a[aCounter];
        return merge(a, aCounter + 1, b, bCounter, out, outCounter + 1);
    }

    if(bCounter < b.length) //only b has elements
    {
        out[outCounter] = b[bCounter];
        return merge(a, aCounter, b, bCounter + 1, out, outCounter + 1);
    }

    //no more elements
    return out;
}