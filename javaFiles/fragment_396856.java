public static int functionMemoization(int n){
    int[] array = new int[n+1];     
    for(int i = 0; i < n; i++)
        array[i] = 0;
    return compute(array, n);
}

private static int compute(int[] array, int n){
    int ans = 0;
    if(array[n] > 0)
        return array[n];
    if(n == 0 || n == 1)
        ans = 1;
    else 
        for(int i = 0; i < n; i++)
            ans += compute(array, i);
    array[n] = ans;
    return array[n];
}