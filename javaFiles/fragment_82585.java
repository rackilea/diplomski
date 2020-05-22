package jackcessTest;

import java.io.File;
import java.util.*;
import com.healthmarketscience.jackcess.*;
import com.healthmarketscience.jackcess.util.ExportFilter;
import com.healthmarketscience.jackcess.util.ExportUtil;
import com.healthmarketscience.jackcess.util.SimpleExportFilter;

public class JackcessTest {

    public static void main(String[] args) {
        try (Database db = DatabaseBuilder.open(
                new File("C:/Users/Public/mdbTest.mdb"))) {

            ExportFilter eFilter = new SimpleExportFilter() {
                private List<Column> _cols = new ArrayList<Column>();
                private int _colIdx = 0;
                @Override
                public List<Column> filterColumns(List<Column> columns) {
                    for (Column c : columns) {
                        if (_colIdx++ < 3) _cols.add(c);
                    }
                    return _cols;
                }
            };

            ExportUtil.exportFile(
                    db, 
                    "Members", 
                    new File("C:/Users/Public/zzzJdump.csv"), 
                    true, 
                    ",", 
                    '"', 
                    eFilter);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}