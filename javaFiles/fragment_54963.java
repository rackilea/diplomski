public static void main(String[] args) throws Exception {

    Configuration conf = new Configuration();

    Job job = Job.getInstance(conf, "HeaderParser");
    job.setJarByClass(WordCount.class);
    job.setMapperClass(HeaderParserMapper.class);

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(NullWritable.class);

    job.addCacheFile(new URI("/in/header.txt#header.txt"));
    FileInputFormat.addInputPath(job, new Path("/in/in7.txt"));
    FileOutputFormat.setOutputPath(job, new Path("/out/"));

    System.exit(job.waitForCompletion(true) ? 0:1);
}