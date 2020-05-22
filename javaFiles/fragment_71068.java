private void foo () {
  int[][] bar = new int[10][10];
  bar[1] = null;  
  //at this point, the array that was in bar[1] is eligible for garbage collection
  //unless someone else has a reference to it
}