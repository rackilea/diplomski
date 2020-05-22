boolean linearSearch(int[] a, int x, int start, int end){
  if ((a.length == 0) || (end == 0)) { return false; }
  if (start <= 0) { //We are within the correct part of the array
     if (a[0] == x) { return true; }
  } 
  //recurse
}