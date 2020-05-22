int[] mask = new int[4];
final int MAX_SHIFT = 32;

void set(int b) {
  mask[b / MAX_SHIFT] |= 1 << (b % MAX_SHIFT);
}

boolean isSet(int b) {
  return (mask[b / MAX_SHIFT] & (1 << (b % MAX_SHIFT))) != 0;
}