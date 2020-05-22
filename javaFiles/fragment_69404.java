public class Main {
    public static void main(String[] args) {
        final int[][] array2d = new int[5][];
        for(int i = 0; i < array2d.length;i++) {
            array2d[i] = new int[6];
        }
        //the size of the rows can change with no problem.
        array2d[0] = new int[8];
    }
}