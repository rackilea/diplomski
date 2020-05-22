if(a[i][j] == 0 && b[i][j] == 0)
    c[i][j] = 0;
else if(a[i][j] == 0 || b[i][j] == 0)
    c[i][j] = 1;
else
    c[i][j] = 2;