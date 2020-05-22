int read = 0;
int write = 0;

while (read < array.length) {
     /* Swap the values pointed at by read and write. */
     int temp = array[write];
     array[write] = array[read];
     array[read] = temp;

     /* Advance the read pointer forward to the next unique value.  Since we
      * moved the unique value to the write location, we compare values
      * against array[write] instead of array[read].
      */
     while (read < array.length && array[write] == array[read])
         ++ read;

     /* Advance the write pointer. */
     ++ write;
}