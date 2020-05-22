import java.util.*;
import java.io.*;

public class WordFinder {
    public static final int N = 10;
    public static char[][] grid = new char[N][N];
    public static final String GRID_FILE = "grid.txt";

    public static void initGrid() {
        try {
            File file = new File(GRID_FILE);
            Scanner scanner = new Scanner(file);

            for (int i = 0; scanner.hasNext(); i++) {
                String line = scanner.next();

                for (int j = 0; j < N; j++) {
                    grid[i][j] = line.charAt(j);
                }
            }

            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public static void main(String[] args) {
        initGrid();

        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell);
            }

            System.out.println();
        }
    }
}