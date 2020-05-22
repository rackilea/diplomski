import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixUtil {
    // again this text file must be in the jar file or the code base 
    // at the same location as the class / java files
    public static final String PATH_TO_RSC = "input.txt";

    public static MatrixModel getInput(String resourcePath) {
        InputStream is = MatrixUtil.class.getResourceAsStream(resourcePath);
        if (is == null) {
            String text = "resourcePath is not found and not loading text: " + resourcePath;
            throw new IllegalArgumentException(text);
        }
        return getInput(is);
    }

    public static MatrixModel getInput(InputStream is) {
        MatrixModel model = null;
        try (Scanner scan = new Scanner(is)) {
            List<List<MatrixPosition>> listOfLists = new ArrayList<>();
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (line.trim().isEmpty()) {
                    continue;
                }
                List<MatrixPosition> list = new ArrayList<>();
                for (char c : line.toCharArray()) {
                    list.add(MatrixPosition.getMatrixPosition(String.valueOf(c)));
                }
                listOfLists.add(list);
            }
            MatrixPosition[][] grid = new MatrixPosition[listOfLists.size()][];
            for (int i = 0; i < grid.length; i++) {
                List<MatrixPosition> list = listOfLists.get(i);
                grid[i] = list.toArray(new MatrixPosition[] {});
            }
            model = new MatrixModel(grid, new SpritePosition(1, 1));
        }

        return model;
    }

}