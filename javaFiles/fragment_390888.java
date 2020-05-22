int length = A.length<B.length? A.length:B.length;
for (int i=0; i<length; i++)
{
    int x = A[i]^B[i];
    if (x != 0)
    {
        for (int j=0; true; j++)
        {
            if ((x&1) == 1)
                return Byte.SIZE*i+j;
            x >>= 1;
        }
    }
}
return -1;