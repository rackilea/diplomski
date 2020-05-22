import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @author sreeveni
 *
 */
public class Mapper1 extends Mapper<LongWritable, Text, Text, Text> {
    Text keyEmit = new Text();
    Text valEmit = new Text();

    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        String parts[] = line.split(" ");
        keyEmit.set(parts[0]);
        valEmit.set(parts[1]);
        context.write(keyEmit, valEmit);
    }
}