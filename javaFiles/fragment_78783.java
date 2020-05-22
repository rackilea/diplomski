int counter = 1;
for(int i=0 ; i<arr.length ; i++) {
    if(i>0 && arr[i-1]!=arr[i]) {
        counter = 1;
    }
    result[i] = counter;
    counter++;
}