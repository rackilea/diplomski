int i = 0;
int j = 0; 

while(i < A.length){
    while(j < B.length){
        if(A[i]-B[j] <= T){
            if(A[i]-B[j] >= -1 * T){
                addPair(i, j);
                j++;//don't consider this value the next time
            }
            break;
        } 
        j++;
    }
    i++;
}