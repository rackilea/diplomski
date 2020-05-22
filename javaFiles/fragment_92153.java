import java.util.Arrays;

public class MySolution {
    public static void stableSort(String[][] table, int column) {
        String[] temp = null;
        int rows = table.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < (rows - i); j++) {
                if (table[j - 1][column].compareTo(table[j][column]) > 0) {
                    temp = table[j - 1];
                    table[j - 1] = table[j];
                    table[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[][] table = { { "c", "d" }, { "a", "b" } };
        printTable(table);
        stableSort(table, 1);
        printTable(table);
    }

    private static void printTable(String[][] table) {
        System.out.println("table:");
        for (int i = 0; i < table.length; i++) {
            System.out.println(Arrays.toString(table[i]));
        }
    }
}