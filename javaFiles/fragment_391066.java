public void bubbleSort(int[] arr) {
  boolean swapped = true;
  int j = 0;
  temp = 0;

while(swapped) {
  swapped = false;
  j++;

for(int i = 0; i < arr.length-j; i++) {
  if (arr[i] > arr[i + 1]) {
    temp = arr[i];
    arr[i] = arr[i + 1];
    arr[i + 1] = temp;
    swapped = true;
  }
 }
}
}

public int[] selectionSort(int[] arr) {
  int i = 0;
  int j = 0;
  int minValue = 0;
  int minIndex = 0;
  int temp = 0;

for(i = 0; i < arr.length - 1; i++) {
   minValue = arr[i];
   minIndex = i;

for(j = i+1; j < arr.length; j++) {
  if (minValue < arr[j]) {
    minValue = arr[j];
    minIndex = j;
  }
}

if (minValue < arr[i]) {
   temp = arr[i];
   arr[i] = minValue;
   arr[minIndex] = temp;
}
}
return arr;
}