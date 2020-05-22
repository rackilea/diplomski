for(int j=0;j<arraySize;j++) {
for(int i=0;i<arraySize;i++){
    if(array[i]<array[i+1]){
    }else if(array[i]>array[i+1]){
        int storeNumber=array[i];
        array[i]=array[i+1];
        array[i+1]=storeNumber;
    } 
}
}