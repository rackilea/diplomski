public class HelloWorld {

   public static class MapReduceMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable> {


     public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(value.toString());
        String row;
        String[] pre;
        int[] tokens;
        while (scanner.hasNext()) {
          row = scanner.nextLine();
          pre = row.split("\\t");
          tokens = new int[pre.length];

          for(int i=0; i<pre.length;i++) {
            tokens[i] = Integer.parseInt(pre[i]);
          }
          System.err.println("MapKey: " + tokens[0] + "MapValue: " + tokens[1]);
          context.write(new IntWritable(tokens[0]), new IntWritable(tokens[1]));

        }
        scanner.close();
     }
  } 

 public static class MapReduceReducer extends Reducer<IntWritable, IntWritable, Text, NullWritable> {

   NullWritable NULL = NullWritable.get();

   public void reduce(IntWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
    int sum = 0;
    int count = 0;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (IntWritable val : values) {
        int a = val.get();
            if (a > max) {
                max = a; }
            else if (a < min) {
                a = min;
                        }
            sum += a;
            count++;
    }

    String keyValue = "Product "  + key.get() + ": ";
    context.write(new Text(keyValue + "Mean = " + (sum / count)), NULL);
    context.write(new Text(keyValue + "Count = " + count), NULL);
    context.write(new Text(keyValue + "Min = " + min), NULL);
    context.write(new Text(keyValue + "Max = " + max), NULL);

   }
 }

 public static void main(String[] args) throws Exception {
   Configuration conf = new Configuration();
   FileSystem fs = FileSystem.get(conf);

   Job job = new Job(conf, "mapreduce");

   job.setJarByClass(HelloWorld.class);

   job.setMapOutputKeyClass(IntWritable.class);
   job.setMapOutputValueClass(IntWritable.class);
   job.setOutputKeyClass(Text.class);
   job.setOutputValueClass(NullWritable.class);

   job.setMapperClass(MapReduceMapper.class);
   job.setReducerClass(MapReduceReducer.class);

   job.setInputFormatClass(TextInputFormat.class);
   job.setOutputFormatClass(TextOutputFormat.class);

   FileInputFormat.addInputPath(job, new Path(args[0])); 
   String outputFile = args[1];  
   Path outPath = new Path(outputFile);
   fs.delete(outPath, true);
   FileOutputFormat.setOutputPath(job, new Path(outputFile)); 

   job.waitForCompletion(true);
 }

}