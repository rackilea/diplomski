public void sort(Numlist numbers) {
  // No copying `numbers` to a `tmp` queue: just work with it directly.
  Numlist zeroes, ones;

  for (int k = 1; k < 32; k++) {
    // Build this step's masking value, which we can use to
    // find the value of individual bits by using bitwise AND.
    // Also note that we _know_ this is a safe integer operation.
    mask = (int) Math.pow(2,k);

    // just allocate new lists; it's about as fast as clearing.
    zeroes = new Numlist();
    ones = new Numlist();

    // "scatter": now we empty the numbers list one element at a
    //  time, and then we'll fill it back up after we emptied it.
    while (!numbers.isEmpty()) {
      int e = numbers.remove(0);

      if ((e & mask) == mask) {
        ones.add(e);
      } else {
        zeroes.add(e);
      }        
    }

    // "gather"
    for (int i: zeroes) { numbers.add(i); }
    for (int i: ones) { numbers.add(i); }      
  }
}