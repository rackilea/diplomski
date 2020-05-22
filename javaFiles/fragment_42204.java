public static final String buildSquare(final int from, final int to) {
    final StringBuilder sb = new StringBuilder(side * side);

    final int side = to - from + 1;

    for (int row = 0; row < side; row++) {
        for(int col = 0; col < side; col++) {
            sb.append( from + ((row + col) % side) );
        }
        sb.append("\n");
    }
    return sb.toString();

}

public static void main(String[] args) {
    System.out.println(buildSquare(1, 5));
    System.out.println(buildSquare(3, 9));
    System.out.println(buildSquare(5, 5));
    System.out.println(buildSquare(0, 9));
    System.out.println(buildSquare(0, 3));
}