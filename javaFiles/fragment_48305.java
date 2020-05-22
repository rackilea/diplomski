int size = arr.length;
for(int i=0;i<size;i++){
        for(int j=0;j<size-i;j++){
                int tmp = arr[i][j];
                arr[i][j] = arr[size-j-1][size-i-1];
                arr[size-j-1][size-i-1] = tmp;
        }                                                      
}