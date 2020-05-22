Integer[] arr = ...
Integer[][] pointerToPointer = {arr};
Iterator<Integer> it = new Iterator<>(new Integer[][]{pointerToPointer});

//use your iterator, including remove() method
...

arr = pointerToPointer[0]; //this gets the modified array