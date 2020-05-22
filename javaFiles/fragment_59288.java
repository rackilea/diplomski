import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    final private static List<String> lines = Arrays.asList(
            "a,4,5,3,2",
            "b,6,4,6,7",
            "c,5,3,7,2",
            "2d,1,4,5,9",
            "4e,4,2,5,7",
            "m4,7,5,3,",
            "xyz,1,6,4,8");
    final private static List<String> labelsInFirstColumn = Arrays.asList(
            "a",
            "c",
            "2d",
            "m4",
            "xyz");

    public static void main(String[] args) {

        List<String[]> result = new ArrayList<String[]>();

        for (String line : lines) {

            String columns[] = line.split("[,]");

            if (labelsInFirstColumn.contains(columns[0])) {

                result.add(columns);

            }

        }

        for (String[] selectedLine : result) {
            for (String column : selectedLine) {
                System.out.print(column + " | ");
            }
            System.out.println();
        }
    }
}