int ears(int[] bunnies) {
  return Ears(bunnies, 0);
}

int ears(int[] bunnies, int index) {
    int ears = countEars(bunnies, index);
    return ears + ears(bunnies, index + 1);
}