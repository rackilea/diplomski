boolean isSorted = false; // assume array is not sorted

while (!isSorted) {  //repeat until array is sorted

     isSorted = true;  // assume array is sorted

     for (int i = 0; i < values.length - 1; i++) { //loop through array
         int a = values[i];  //get first value to compare
         int b = values[i + 1];  // get second value to compare

         if (a < b) {  // if first value is less than second, swap them
             swap(values, i, i + 1);
             isSorted = false;  // there was a change so array is not actually sorted! So we will have to loop through whole array again
         }
     }
}