min = arr[0];
for (j=0; j < arr.length; j++) {
    if (arr[j] < min) {  //<---fix is here
        min = arr[j];
    }
}