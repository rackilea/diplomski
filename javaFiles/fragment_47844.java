public final class TableFormatter {
private static final int[][][] TABLE = {
        {{8, 0, 0, 0, 0, 3, 0, 7, 0}, {0, 0, 0, 6, 0, 0, 0, 9, 0}, {0, 0, 0, 0, 0, 0, 2, 0, 0}},
        {{0, 5, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 7, 0, 4, 5, 1, 0, 0}, {0, 0, 0, 7, 0, 0, 0, 3, 0}},
        {{0, 0, 1, 0, 0, 8, 0, 9, 0}, {0, 0, 0, 5, 0, 0, 0, 0, 0}, {0, 6, 8, 0, 1, 0, 4, 0, 0}}
};

public static void main(String[] args) {
    TableFormatter formatter = new TableFormatter(TABLE);
    System.out.println(formatter.toString());
}

private final int[][][] array3d;

public TableFormatter(int[][][] array3d) {
    this.array3d = array3d;
}

@Override
public String toString() {
    StringBuilder builder = new StringBuilder();
    for (int[][] array2d : array3d) {
        append2dArray(builder, array2d);
        builder.append('\n');
    }
    return builder.toString();
}

private void append2dArray(StringBuilder builder3d, int[][] array2d) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            StringBuilder builder2d = new StringBuilder("[");
            for (int k = 0; k < 3; k++) {
                builder2d.append(array2d[j][(i * 3) + k]).append(',');
            }
            builder2d.deleteCharAt(builder2d.length() - 1).append("]\t");
            builder3d.append(builder2d);
        }
        builder3d.append('\n');
    }
}
}