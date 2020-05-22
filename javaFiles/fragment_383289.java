boolean linearSearch(int[] a, int x, int start, int end){
  if ((a.length == 0) || (end == 0)) { return false; }
  if (start <= 0) { //We are within the correct part of the array
     int head = a[0]; //The head is the first part of an array
     if (head == x) { return true; }
  } 
  // The tail is everything but the head
  int[] tail = Arrays.copyOfRange(a, 1, a.length); //Be careful of off-by-one errors!
  return linearSearch(tail, x, start - 1, end - 1);
}