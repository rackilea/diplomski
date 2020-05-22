int left = 0, right, pos;
for (pos = 0; pos <= a.length; ++pos) {
  if (pos < a.length && a[pos] != 7)
    continue; // no need to split, so simply go on
  for (right = pos; right != left; --right) // drop trailing -14s
    if (a[right - 1] != -14)
      break;
  // "right" now is one past the last element we want to keep
  for (; left != right; ++left) // drop leading -14s
    if (a[left] != -14)
      break;
  if (left != right) {
    byte[] b = new int[right - left];
    System.arraycopy(a, left, b, 0, right - left);
    res.add(b);
  }
  left = pos + 1;
}