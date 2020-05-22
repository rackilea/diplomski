boolean isOrdered = true;

while(isOrdered && array.length - 1 > b){
     if(array[b] > array[b+1]) isOrdered = false;
     b++;
}