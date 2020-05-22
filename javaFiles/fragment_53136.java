private static void copy_Matrix(int origin_Matrix[][] , int copy_Matrix[][])
{
    /* assert origin_Matrix.length == copy_Matrix.length */
    for ( int i = 0 ; i < origin_Matrix.length; i++)
    {
        /* assert origin_Matrix[i].length == copy_Matrix[i].length */
        System.arraycopy(origin_Matrix[i], 0, copy_Matrix[i], 0, origin_Matrix[i].length);
    }
}