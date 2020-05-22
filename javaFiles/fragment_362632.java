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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieGroupings {

    public static class MovieGroupingsMapper
            extends Mapper<LongWritable, Text , Text, Text>{

        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

            String valueStr = value.toString().trim();
            String[] tokens = valueStr.split("\t"); // Assume key/values to be tab seperated. For e.g. "17    1,3,(70,3)"

            if(tokens.length == 2) {
                int index = tokens[1].indexOf('('); // Search for "(" character
                if(index != -1)
                {
                    context.write(new Text(tokens[0]), new Text(tokens[1].substring(index+1, tokens[1].length() - 1)));  // Exclude '(' and ')'
                }
            }
        }
    }

    public static class MovieGroupingsReducer
            extends Reducer<Text, Text, Text, Text> {

        public void reduce(Text key, Iterable<Text> values,
                           Context context) throws IOException, InterruptedException {

            for (Text value : values) {
                String[] tokens = value.toString().split(" "); // Split the values based on blank character

                if(tokens.length >= 2) // Ignore if there is only one movie
                {
                    for(int i = 0; i < tokens.length; i++)
                        for(int j = i + 1; j < tokens.length; j++) {
                            String groupings = tokens[i] + "," + tokens[j]; // Add 2 movies with ",". For e.g. "19,2,21,1"
                            String[] moviesAndRatings = groupings.split(",");
                            if (moviesAndRatings.length == 4)
                                context.write(new Text(moviesAndRatings[0] + "," + moviesAndRatings[2]),
                                        new Text(moviesAndRatings[1] + "," + moviesAndRatings[3]));
                        }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();

        Job job = Job.getInstance(conf, "MovieGroupings");
        job.setJarByClass(MovieGroupings.class);
        job.setMapperClass(MovieGroupingsMapper.class);
        job.setReducerClass(MovieGroupingsReducer.class);
        job.setNumReduceTasks(5);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job, new Path("/in/in5.txt"));
        FileOutputFormat.setOutputPath(job, new Path("/out/"));

        System.exit(job.waitForCompletion(true) ? 0:1);
    }
}