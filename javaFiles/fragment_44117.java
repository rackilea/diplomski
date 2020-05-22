int k=l;

while (i<L.length && j<R.length){
    if(L[i]<R[j]){
        A[k] = L[i];
        i++;
    }
    else{
        A[k] = R[j];
        j++;
    }
    k++;
}

while(i<L.length){
    A[k] = L[i];
    k++;
    i++;
}
while(j<R.length){
    A[k] = R[j];
    k++;
    j++;
}
return A;