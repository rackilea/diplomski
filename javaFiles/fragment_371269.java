private Integer[] mergesort(Integer[] array) {
  if(array.length > 1) {
      Integer[] left = new Integer[array.length /2];
      Integer[] right = new Integer[array.length - left.length];

      mergesort(left); //problem 1.5: more on this later...
      mergesort(right);

      merge(left, right); //problem 2: stored array is returned but not stored
    }
    return array; //problem 1: returns array unchanged
}