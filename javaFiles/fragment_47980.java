public static int func(int n){
    int result;
    if (n >= 0)
        result = func(n - 1);
    else
        result = 0;
    return result;
}