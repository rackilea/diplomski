package com.hadooptests;

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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cities {

    public static class CityMapper
            extends Mapper<LongWritable, Text, Text, IntWritable> {

        private Text outKey = new Text();
        private IntWritable outValue = new IntWritable(1);

        public void map(LongWritable key, Text value, Context context
        ) throws IOException, InterruptedException {
              outKey.set(value);
              context.write(outKey, outValue);
        }
    }

    public static class CityReducer
            extends Reducer<Text,IntWritable,Text,Text> {

        HashMap<String, Integer> cityCount = new HashMap<String, Integer>();

        public void reduce(Text key, Iterable<IntWritable>values,
                           Context context
        ) throws IOException, InterruptedException {

            for (IntWritable val : values) {
                String keyStr = key.toString();
                if(keyStr.toLowerCase().startsWith("city|")) {
                    String[] tokens = keyStr.split("\\|");

                    if(cityCount.containsKey(tokens[1])) {
                        int count = cityCount.get(tokens[1]);
                        cityCount.put(tokens[1], ++count);
                    }
                    else
                        cityCount.put(tokens[1], val.get());
                }
            }
        }

        @Override
        public void cleanup(org.apache.hadoop.mapreduce.Reducer.Context context)
                throws IOException,
                InterruptedException
        {
            String output = "{\"city\":{";
            Iterator iterator = cityCount.entrySet().iterator();
            while(iterator.hasNext())
            {
                Map.Entry entry = (Map.Entry) iterator.next();
                output = output.concat("\"" + entry.getKey() + "\":" + Integer.toString((Integer) entry.getValue()) + ", ");
            }

            output = output.substring(0, output.length() - 2);
            output = output.concat("}}");
            context.write(output, "");
        }
    }


    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "KeyValue");

        job.setJarByClass(Cities.class);
        job.setMapperClass(CityMapper.class);
        job.setReducerClass(CityReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job, new Path("/in/in.txt"));
        FileOutputFormat.setOutputPath(job, new Path("/out/"));

        System.exit(job.waitForCompletion(true) ? 0:1);

    }
}