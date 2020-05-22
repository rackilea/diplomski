public class IsJaggedDemo {
    private static boolean IsJagged(int[][] array) {
        boolean isJagged = false;

        if (array != null) {
            Integer lastLength = null;
            for (int i = 0; i < array.length; i++) {
                if (lastLength == null) {
                    lastLength = array[i].length;
                } else if (lastLength.equals(array[i].length)) {
                    continue;
                } else {
                    isJagged = true;
                    break;
                }
            }
        }

        return isJagged;
    }

    private static boolean IsSquare(int[][] array) {
        boolean isSquare = false;

        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i].length != array.length) {
                    break;
                } else if (i != array.length - 1) {
                    continue;
                } else {
                    isSquare = true;
                }
            }
        }

        return isSquare;
    }

    public static void main(String[] args) {
        int[][] a = null;
        int[][] b =
            new int[][] {
                new int[] { 1 }
            };
        int[][] c =
            new int[][] {
                new int[] { 1, 2, 3 },
                new int[] { 4, 5, 6 },
                new int[] { 7, 8, 9 }
            };
        int[][] d =
            new int[][] {
                new int[] { 1, 2, 3 },
                new int[] { 4, 5, 6 },
                new int[] { 7, 8, 9, 10 }
            };
        int[][] e =
            new int[][] {
                new int[] { 1, 2, 3 }
            };
        int[][] f =
            new int[][] {
                new int[] { 1, 2, 3 },
                new int[] { 4, 5, 6 },
                new int[] { 7, 8, 9 },
                new int[] { 9, 8, 7 }
            };

        System.out.printf(
                "a is %1$sjagged and is %2$ssquare.\r\n",
                IsJagged(a) ? "" : "not ",
                IsSquare(a) ? "" : "not ");
        System.out.printf(
                "b is %1$sjagged and is %2$ssquare.\r\n",
                IsJagged(b) ? "" : "not ",
                IsSquare(b) ? "" : "not ");
        System.out.printf(
                "c is %1$sjagged and is %2$ssquare.\r\n",
                IsJagged(c) ? "" : "not ",
                IsSquare(c) ? "" : "not ");
        System.out.printf(
                "d is %1$sjagged and is %2$ssquare.\r\n",
                IsJagged(d) ? "" : "not ",
                IsSquare(d) ? "" : "not ");
        System.out.printf(
                "e is %1$sjagged and is %2$ssquare.\r\n",
                IsJagged(e) ? "" : "not ",
                IsSquare(e) ? "" : "not ");
        System.out.printf(
                "f is %1$sjagged and is %2$ssquare.\r\n",
                IsJagged(f) ? "" : "not ",
                IsSquare(f) ? "" : "not ");
    }
}