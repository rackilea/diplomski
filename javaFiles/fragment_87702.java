double kernel_function(int i, int j)
{
    switch(kernel_type)
    {
        /* ... snip ...*/
        case svm_parameter.PRECOMPUTED:
            return x[i][(int)(x[j][0].value)].value;
        /* ... snip ...*/
    }
}