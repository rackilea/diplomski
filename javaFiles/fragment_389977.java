import java.util.ArrayList;
import java.util.List;

public class MyClass {

    public static String[][] expandColumn(String[][] masterArray) {
        List<String[]> masterOutputList = new ArrayList<>();
        for (int i = 0; i < masterArray.length; i++) {
            String itemToExpand = masterArray[i][masterArray[i].length - 1];
            String[] parts = itemToExpand.split(",");
            for (int j = 0; j < parts.length; j++) {
                String[] row = new String[masterArray[i].length];
                System.arraycopy(masterArray[i], 0, row, 0, masterArray[i].length - 1);
                row[row.length - 1] = parts[j];
                masterOutputList.add(row);
            }
        }
        return masterOutputList.toArray(new String[0][0]);
    }

    public static void main(String[] args) {
        String[][] masterArray = {
                {"hi", "good", "morning,afternoon"},
                {"have a", "nice", "day,trip,journey"},
                {"hi", "good", "evening"},
                {"I", "love", "you,India"},
                {"enjoy", "your", "dinner"}
        };
        String[][] ss = expandColumn(masterArray);
        for (int i = 0; i < ss.length; i++) {
            for (int j = 0; j < ss[i].length; j++) {
                System.out.print(ss[i][j]);
            }
            System.out.println();
        }
    }

}