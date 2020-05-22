public static int[] convertToBinary(int b) {
  if (b < 0 || b > 255) {
    throw new IllegalArgumentException("Argument must be between 0 and 255");
  }
  int[] result = new int[8];
  // Working from the right side of the array to the left, we store the bits.
  for (int i = 7; i >= 0; i--) {
    result[i] = b & 1; // Same as b % 2
    b >>>= 1; // Same as b /= 2
  }
  return result;
}


public static int[] addBin(int[] a, int[] b) {
  if (a.length != 8 || b.length != 8) {
    throw new IllegalArgumentException("Arguments must be octets");
  }
  for (int i = 0; i < 8; i++) {
    if (a[i] < 0 || a[i] > 1 || b[i] < 0 || b[i] > 1) {
      throw new IllegalArgumentException("Arguments must be binary");
    }
  }
  // Working from the right side of the array to the left, we find the sum.
  int[] result = new int[8];
  for (int i = 7; i >= 1; i--) {
    int sum = result[i] + a[i] + b[i]; // result[i] holds the carry from the last addition.
    result[i] = sum & 1; // Same as sum % 2
    result[i - 1] = sum >>> 1; // Same as sum / 2. This is the carry.
  }
  // The highest-order bit (bit 0) is handled as a special case to detect overflow.
  int sum = result[0] + a[0] + b[0];
  result[0] = sum & 1;
  if (sum >>> 1 > 0) {
    throw new IllegalArgumentException("Overflow");
  }
  return result;
}