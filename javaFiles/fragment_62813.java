public class ProtectArrayFromOverwrite {

static int[][] data = new int[5][5];
static boolean[][] containsData = new boolean[5][5];

public static void main(String[] args) {

    // Try to write the value 10, to the cell [1][1]
    boolean didAdd = addData(1, 1, 10);
    System.out.println(didAdd);  // True - the write worked
    // Try to write the value 20, to the cell [1][1]
    didAdd = addData(1, 1, 20);
    System.out.println(didAdd);  // False - the cell already had a value

}

public static boolean addData(int x, int y, int value) {
    if (containsData[x][y] == false) {
        data[x][y] = value;
        containsData[x][y] = true;
        return true;
    }
    return false;
}

}