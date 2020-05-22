import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @author sreeveni
 *
 */
public class ReducerJoin extends Reducer<Text, Text, Text, Text> {

    Text valEmit = new Text();
    String merge = "";

    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        String character = "";
        String number = "";
        for (Text value : values) {
            // ordering output
            String val = value.toString();
            char myChar = val.charAt(0);

            if (Character.isDigit(myChar)) {
                number = val;
            } else {
                character = val;
            }
        }
        merge = character + " " + number;
        valEmit.set(merge);
        context.write(key, valEmit);
    }

}