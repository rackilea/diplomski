import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class AReducer extends Reducer<Text, Text, Text, NullWritable>{
    private MultipleOutputs<Text, NullWritable> mos = null;

    @Override
    public void setup(Context context) throws IOException {
        mos = new MultipleOutputs<Text, NullWritable>(context);
    }

    @Override
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        mos.write(key, NullWritable.get(), "filename");
    }

    @Override
    public void cleanup(Context context) throws IOException, InterruptedException {
        mos.close();
    }
}