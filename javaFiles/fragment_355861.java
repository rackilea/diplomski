if(x + A.length <= B.length && y + A.length <= B.length){   //Check for legal input
for (int i = 0; i < A.length; i++){
    for (int j = 0; j < A.length; j++){
        C[x+i][y+j]= A[i][j];
    }
}
return C