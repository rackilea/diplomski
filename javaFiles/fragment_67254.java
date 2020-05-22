int[] input = [6,5,4,3,2,1]
mergeSort(input,0,input.length-1)
System.out.println(Arrays.toString(input))     

void mergeSort(int[] A,int p,int r){
    if(p < r){
        int q = (int) Math.floor((p+r)/2)
        mergeSort(A,p,q)
        mergeSort(A,q+1,r)
        merge(A,p,q,r)
    }
}

void merge(int[] A,int p,int q,int r) {
    int i = 0
    int j = 0
    int n1 = q - p + 1
    int n2 = r - q
    int[] L = new int[n1]
    int[] R = new int[n2]
    for(;i<n1;i++){ L[i] = A[p+i] }
    for(;j<n2;j++){ R[j] = A[q+j+1] }
    i = j = 0
    for(int k = p; k <= r; k++){
        if(j >= n2 || (i < n1 && L[i] < R[j] )) { A[k] = L[i++] }
        else{ A[k] = R[j++] }
    }    
}