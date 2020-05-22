public class WordCountJobControl
{
    public static void main(String args[]) throws Exception
    {
        Job job=new Job();
        job.setJobName("Length");
        job.setJarByClass(WordCountJobControl.class);
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));
        System.exit(job.waitForCompletion(true)?0:1);
    }
}