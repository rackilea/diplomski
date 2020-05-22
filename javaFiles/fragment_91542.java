private static int count8(int n, boolean eight) {
  if (n <= 0)
    return 0;
  else if (n % 10 == 8)
    return 1 + (eight ? 1 : 0) + count8(n / 10, true);
  else
    return count8(n / 10, false);
}

public static int count8(int n) {
  return count8(n, false);
}