public class MatrixSorter {

    static class IntPos {
        public int num, pos;

        IntPos(int num, int pos) {
            this.num = num;
            this.pos = pos;
        }

        @Override
        public String toString() {
            // For testing purposes to use Arrays.toString
            return String.valueOf(pos + 1);
        }
    }

    private static int[] getSortedPositions(int[] nums) {
        IntPos[] positions = new IntPos[nums.length];

        for (int i = 0; i < nums.length; i++) {
            positions[i] = new IntPos(nums[i], i);
        }

        Arrays.sort(positions, new Comparator<IntPos>() {
            @Override
            public int compare(IntPos o1, IntPos o2) {
                return -1 * Integer.compare(o1.num, o2.num);
            }
        });

        int[] sortedPos = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sortedPos[i] = positions[i].pos + 1;
        }

        return sortedPos;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{10, 50, 10}, {3, 5, 1}, {100, 500, 800}};
        int[][] matrix2 = {{30, 30, 30}, {3, 3, 3}, {300, 300, 300}};
        int[][] matrix3 = {{20, 20, 20}, {2, 2, 2}, {200, 200, 200}};
        int[][][] nonSortedMatrices = {matrix1, matrix2, matrix3};

        final int MATRIX_SIZE = nonSortedMatrices.length;
        int[][][] sortedMatrices = new int[MATRIX_SIZE][MATRIX_SIZE][MATRIX_SIZE];

        for (int r = 0; r < MATRIX_SIZE; r++) {
            for (int c = 0; c < MATRIX_SIZE; c++) {

                int[] nums = new int[MATRIX_SIZE];
                for (int d = 0; d < MATRIX_SIZE; d++) {
                    nums[d] = nonSortedMatrices[d][r][c];
                }
                int[] sortedPos = getSortedPositions(nums);

                for (int d = 0; d < MATRIX_SIZE; d++) {
                    sortedMatrices[d][r][c] = sortedPos[d];
                }
            }
        }
    }
}