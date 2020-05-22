public class Friends {

    public static class FriendsMap extends Mapper <...> {}

    public static class FriendReducer extends Reducer <...> {}

    public static void main( String[] args) throws Exception { 
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Friends");
        job.setJarByClass(Friends.class);
        FileInputFormat.addInputPath(job, new Path("input")); 
        FileOutputFormat.setOutputPath(job, new Path("output")); 
        job.setMapperClass(FriendsMap.class); 
        job.setCombinerClass(FriendReducer.class); 
        job.setReducerClass(FriendReducer.class);
        job.setOutputKeyClass(Text.class); 
        job.setOutputValueClass(IntWritable.class);

        System.exit( job.waitForCompletion( true) ? 0 : 1); 
    }
}