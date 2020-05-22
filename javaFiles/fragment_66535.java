int numSmaller(int[] seq, int valueToFind)
{
    int pos=0;
    int limit=seq.length;
    while(pos<limit)
    {
        int testpos = pos+((limit-pos)>>1);

        if (seq[testpos]<valueToFind)
            pos=testpos+1;
        else
            limit=testpos;
    }
    return pos;
}