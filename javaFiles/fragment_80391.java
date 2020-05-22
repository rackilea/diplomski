// Empty
  static final int MT = -1;

  static int kRooksPermutations(int[] Q, int col, int rooksInHand) {
    // Are we at the last col?
    if (col >= Q.length) {
      // If we've placed K rooks then its a good'n.
      return rooksInHand == 0 ? 1 : 0;
    }

    // Count at this level starts at 0
    int count = 0;
    // Have we run out of rooks?
    if (rooksInHand > 0) {
      // No! Try putting one in each row in this column.
      for (int row = 0; row < Q.length; row++) {
        // Can a rook be placed here?
        if (safeToAdd(Q, row, col)) {
          // Mark this spot occupied.
          Q[col] = row;
          // Recurse to the next column with one less rook.
          count += kRooksPermutations(Q, col + 1, rooksInHand - 1);
          // No longer occupied.
          Q[col] = MT;
        }
      }
    }
    // Also try NOT putting a rook in this column.
    count += kRooksPermutations(Q, col + 1, rooksInHand);

    return count;
  }

  static boolean safeToAdd(int[] Q, int row, int col) {
    // Unoccupied!
    if (Q[col] != MT) {
      return false;
    }
    // Do any columns have a rook in this row?
    // Could probably stop at col here rather than Q.length
    for (int c = 0; c < Q.length; c++) {
      if (Q[c] == row) {
        // Yes!
        return false;
      }
    }
    // All clear.
    return true;
  }

  // Main entry - Build the array and start it all going.
  private static void kRooksPermutations(int N, int K) {
    // One for each column of the board.
    // Contains the row number in which a rook is placed or -1 (MT) if the column is empty.
    final int[] Q = new int[N];
    // Start all empty.
    Arrays.fill(Q, MT);
    // Start at column 0 with no rooks placed.
    int perms = kRooksPermutations(Q, 0, K);
    // Print it.
    System.out.println("Perms for N = " + N + " K = " + K + " = " + perms);
  }

  public static void main(String[] args) {
    kRooksPermutations(8, 1);
    kRooksPermutations(8, 2);
    kRooksPermutations(8, 3);
    kRooksPermutations(8, 4);
    kRooksPermutations(8, 5);
    kRooksPermutations(8, 6);
    kRooksPermutations(8, 7);
    kRooksPermutations(8, 8);
  }