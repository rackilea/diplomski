public class DynamicArray {
    private int[][] array;
    private int[] size;

    public DynamicArray(int initialSize) {
        array = new int[10][initialSize];
        size = new int[10];
    }

    public int get(int rowNum, int colNum) {
        return array[rowNum][colNum];
    }

    public int getSize(int rowNum) {
        return size[rowNum];
    }

    public void put(int N, int rowNum) {
        if (size[rowNum] < array[0].length)
            array[rowNum][size[rowNum]] = N;
        else { // need to create a bigger array

            int[] temp = new int[2 * size[rowNum]];
            for (int i = 0; i < size[rowNum]; i++) {
                temp[i] = array[rowNum][i];
            }
            array[0] = temp;
            array[0][size[rowNum]] = N;
        }
        size[rowNum] = size[rowNum] + 1;
    }

    public static void main(String[] args) {

        DynamicArray da = new DynamicArray(3);
        da.put(2, 0);
        da.put(1, 0);
        da.put(3, 0);
        da.put(1, 0);
        da.put(4, 0);
        da.put(5, 1);
        da.put(2, 4);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < da.getSize(i); j++) {
                System.out.print((da.get(i, j) + "\t"));
            }
            System.out.println("\n");
        }
    }

}