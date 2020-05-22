int [] arr = new int[]{1,2,3,4,5};
    int [] expected = new int[]{3,4,5,6,5,6,7,7,8,9};
    int N = arr.length;
    for(int i=0; i<N - 1; i++){
      for(int j=i+1; j<N; j++){
           int temp = arr[i] + arr[j];
           if(temp == expected[getIndex(i,j,N)]){
                 #logic
           }
       }
     }
}

public static int getIndex(int i, int j, int N) {
    return S(N) - S(N-i) + j-i -1;
}

public static int S(int N) {
    return N * (N - 1) / 2;
}