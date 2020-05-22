final StringBuilder sb = new StringBuilder();
final int n = (int) Math.sqrt(squares.length);
for (int row = 0; row < n; row++) {
    for (int col = 0; col < n; col++) {
        final int offset = row * n + col;
        final Square square = squares[offset];
        sb.append(square.toString())

        final boolean lastCol = col == (n - 1);
        sb.append(lastCol ? "\n" : " ");
    }
}
return sb.toString();