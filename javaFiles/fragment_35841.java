long next_of_n(long j) {
  long smallest, ripple, new_smallest, ones;
  if (j == 0)
    return j;
  smallest = (j & -j);
  ripple = j + smallest;
  new_smallest = (ripple & -ripple);
  ones = ((new_smallest / smallest) >> 1) - 1;
  return (ripple | ones);
}