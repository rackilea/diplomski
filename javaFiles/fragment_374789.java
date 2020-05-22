import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @author sreeveni
 *
 */
public class Driver extends Configured implements Tool {
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        // checking the arguments count

        if (args.length != 3) {
            System.err
                    .println("Usage : <inputlocation>  <inputlocation>  <outputlocation> ");
            System.exit(0);
        }
        int res = ToolRunner.run(new Configuration(), new Driver(), args);
        System.exit(res);

    }

    @Override
    public int run(String[] args) throws Exception {
        // TODO Auto-generated method stub
        String source1 = args[0];
        String source2 = args[1];
        String dest = args[2];
        Configuration conf = new Configuration();
        conf.set("mapred.textoutputformat.separator", " "); // changing default
                                                            // delimiter to user
                                                            // input delimiter
        FileSystem fs = FileSystem.get(conf);
        Job job = new Job(conf, "Multiple Jobs");

        job.setJarByClass(Driver.class);
        Path p1 = new Path(source1);
        Path p2 = new Path(source2);
        Path out = new Path(dest);
        MultipleInputs.addInputPath(job, p1, TextInputFormat.class,
                Mapper1.class);
        MultipleInputs.addInputPath(job, p2, TextInputFormat.class,
                Mapper1.class);
        job.setReducerClass(ReducerJoin.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setOutputFormatClass(TextOutputFormat.class);

        /*
         * delete if exist
         */
        if (fs.exists(out))
            fs.delete(out, true);

        TextOutputFormat.setOutputPath(job, out);
        boolean success = job.waitForCompletion(true);

        return success ? 0 : 1;
    }

}