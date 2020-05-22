package com.myorg.hadooptests;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MovieRatings {


    public static class MovieRatingsMapper
            extends Mapper<LongWritable, Text , IntWritable, Text>{

        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

            String valueStr = value.toString();
            int index = valueStr.indexOf(',');

            if(index != -1) {
                try
                {
                    IntWritable keyUserID = new IntWritable(Integer.parseInt(valueStr.substring(0, index)));
                    context.write(keyUserID, new Text(valueStr.substring(index + 1)));
                }
                catch(Exception e)
                {
                    // You could get a NumberFormatException
                }
            }
        }
    }

    public static class MovieRatingsReducer
            extends Reducer<IntWritable, Text, IntWritable, Text> {

        public void reduce(IntWritable key, Iterable<Text> values,
                           Context context) throws IOException, InterruptedException {

            int movieCount = 0;
            int movieRatingCount = 0;
            String movieValues = "";

            for (Text value : values) {
                String[] tokens = value.toString().split(",");
                if(tokens.length == 2)
                {
                    movieRatingCount += Integer.parseInt(tokens[1].trim()); // You could get a NumberFormatException
                    movieCount++;
                    movieValues = movieValues.concat(value.toString() + " ");
                }
            }

            context.write(key, new Text(Integer.toString(movieCount) + "," + Integer.toString(movieRatingCount) + ",(" + movieValues.trim() + ")"));
        }
    }

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf, "CompositeKeyExample");
        job.setJarByClass(MovieRatings.class);
        job.setMapperClass(MovieRatingsMapper.class);
        job.setReducerClass(MovieRatingsReducer.class);

        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path("/in/in2.txt"));
        FileOutputFormat.setOutputPath(job, new Path("/out/"));

        System.exit(job.waitForCompletion(true) ? 0:1);

    }
}