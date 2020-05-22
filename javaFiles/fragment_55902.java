import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class FlightAnalyse {

  public static class TokenizerMapper
          extends Mapper<Object, Text, Text, IntWritable>{

      private final static IntWritable one = new IntWritable(1);
      private Text delayOrNot = new Text();

      public void map(Object key, Text value, Context context
      ) throws IOException, InterruptedException {

        String[] columns = value.toString().split(",");
        if(columns.length > 15){
            int delay = 0;

            try{  
                delay = (int) Double.parseDouble(columns[15]); //delay in minutes

            }  
            catch(NumberFormatException nfe){  
                return;  
            }  

            //if the differecen is less than 5 minutes
            if(delay <= 5 && delay >= -5)
                delayOrNot.set("NotDelay");
            else
                delayOrNot.set("Delay");

            context.write(delayOrNot, one);
          }
      }
  }

  public static class IntSumReducer
          extends Reducer<Text,IntWritable,Text,IntWritable> {
      private IntWritable result = new IntWritable();

      public void reduce(Text key, Iterable<IntWritable> values,
                         Context context
      ) throws IOException, InterruptedException {
          int sum = 0;
          for (IntWritable val : values) {
              sum += val.get();
          }

          result.set(sum);
          context.write(key, result);
      }
  }

  public static class Reduce
          extends Reducer<Text,IntWritable,Text,FloatWritable> {
      private FloatWritable result = new FloatWritable();
      Float persentage = 0f;
      Float numOfonTime = 0f;
      Float count = 0f;
      public void reduce(Text key, Iterable<IntWritable> values,
                         Context context
      ) throws IOException, InterruptedException {

          for (IntWritable val : values) {
              count += val.get();
              if(key.toString().equals("NotDelay"))
                numOfonTime += val.get();
          }

          persentage = numOfonTime/count;
          result.set(persentage);

          Text sumText = new Text("persentage of  " + key + ": ");
          context.write(sumText, result);
      }
  }

  public static void main(String[] args) throws Exception {
      Configuration conf = new Configuration();
      Job job = Job.getInstance(conf, "Flight Analysis");
      job.setJarByClass(FlightAnalyse.class);
      job.setMapperClass(TokenizerMapper.class);
      job.setCombinerClass(IntSumReducer.class);
      job.setReducerClass(Reduce.class);
      job.setOutputKeyClass(Text.class);
      job.setOutputValueClass(IntWritable.class);
      FileInputFormat.addInputPath(job, new Path(args[0]));
      FileOutputFormat.setOutputPath(job, new Path(args[1]));
      System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}