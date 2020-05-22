void my_puts(char const* s);

void cmp_gt(int x) 
{
    if (x > -1) {
        my_puts("non-negative");
    }
    else {
        my_puts("negative");
    }
}

void cmp_gte(int x) 
{
    if (x >= 0) {
        my_puts("non-negative");
    }
    else {
        my_puts("negative");
    }
}