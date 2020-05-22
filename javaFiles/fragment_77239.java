for (int i = 1; i <= n; i+=2) {
        if( i % 4 == 1 )
            sum = sum + i;
        else
            sum = sum - i;
}