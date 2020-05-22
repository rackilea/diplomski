int getInt(int x, int y) {
  // transform from 2D to 1D
  int pos = y * LENGTH + x;
  // Where LENGTH is the the example: 3

  // For safety assert on length
  if (pos > buffer.length()) throw new ArrayIndexOutOfBoundsException();
  // TODO: assert on min, max (x, y)

  return buffer.getInt(pos);
}