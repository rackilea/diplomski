for(i=0;i<n/2;i++){
    for(j=i; j<n-1-i ; j++){

        //Rotating left by 90 degrees
        temp = a[i][j];
        a[i][j] = a[j][n-1-i];
        a[j][n-1-i] = a[n-1-i][n-1-j];
        a[n-1-i][n-1-j] = a[n-1-j][i];
        a[n-1-j][i] = temp;

        /*  
        //Rotating right by 90 degrees
        temp = a[i][j];
        a[i][j] = a[n-1-j][i];
        a[n-1-j][i] = a[n-1-i][n-1-j];
        a[n-1-i][n-1-j] = a[j][n-1-i];
        a[j][n-1-i] = temp;
        */
    }
}