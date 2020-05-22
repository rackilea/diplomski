int [] y = new int[a.length];
for(int i = 0 ; i < y.length ; i++){
    int sum = 0;
    for(int j = 0 ; j < a[0].length ; j++){
        sum += a[i][j] * x[j];          
    }
    y[i] = sum;
}
return y;