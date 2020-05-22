package cruft;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * CsvParser
 * @author Michael
 * @link http://stackoverflow.com/questions/14114358/reading-csv-file-in-java-and-storing-the-values-in-an-int-array/14114365#14114365
 * @since 1/1/13 4:26 PM
 */
public class CsvParser {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader((args.length > 0) ? args[0] : "resources/test.csv");
            Map<String, List<String>> values = parseCsv(fr, "\\s+", true);
            System.out.println(values);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, List<String>> parseCsv(Reader reader, String separator, boolean hasHeader) throws IOException {
        Map<String, List<String>> values = new LinkedHashMap<String, List<String>>();
        List<String> columnNames = new LinkedList<String>();
        BufferedReader br = null;
        br = new BufferedReader(reader);
        String line;
        int numLines = 0;
        while ((line = br.readLine()) != null) {
            if (StringUtils.isNotBlank(line)) {
                if (!line.startsWith("#")) {
                    String[] tokens = line.split(separator);
                    if (tokens != null) {
                        for (int i = 0; i < tokens.length; ++i) {
                            if (numLines == 0) {
                                columnNames.add(hasHeader ? tokens[i] : ("row_"+i));
                            } else {
                                List<String> column = values.get(columnNames.get(i));
                                if (column == null) {
                                    column = new LinkedList<String>();
                                }
                                column.add(tokens[i]);
                                values.put(columnNames.get(i), column);
                            }
                        }
                    }
                    ++numLines;
                }
            }
        }
        return values;
    }
}