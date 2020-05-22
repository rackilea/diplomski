import java.util.ArrayList;
import java.util.List;

public class RowCombine {

    String[] row;
    List<String> result = new ArrayList<String>();

    public RowCombine(String[] row) {
        this.row = row;
    }

    public String[] combine() {
        if (result.isEmpty()) {
            for (int level = 2; level < row.length; level++) {
                combine(level, 0, row.length - level, "");
            }
        }
        return result.toArray(new String[result.size()]);
    }

    private void combine(int level, int lower, int upper, String value) {
        if (level > 0) {
            for (int c = lower; c <= upper; c++) {
                combine(level - 1, c + 1, upper + 1, value + row[c]);
            }
        } else {
            result.add(value);
        }
    }
}