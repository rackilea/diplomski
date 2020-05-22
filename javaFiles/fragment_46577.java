public class StockJoinJob extends Configured  {

public static class KeyPartitioner extends Partitioner<TextIntPair, TextLongIntPair> {
@Override
public int getPartition(TextIntPair key, TextLongIntPair value, int numPartitions) {
  return (key.getText().hashCode() & Integer.MAX_VALUE) % numPartitions;
}
}  

public static int runJob(String[] args) throws Exception {
      Configuration conf = new Configuration();
      Job job = new Job(conf);
  job.setJarByClass(StockJoinJob.class);

  Path nasdaqPath = new Path(args[0]);
  Path listPath = new Path(args[1]);
  Path outputPath = new Path(args[2]+"-first");

  MultipleInputs.addInputPath(job, listPath, TextInputFormat.class, CompanyMapper.class);
  MultipleInputs.addInputPath(job, nasdaqPath,
  StockInputFormat.class, StockMapper.class);
  FileOutputFormat.setOutputPath(job, outputPath);

  job.setPartitionerClass(KeyPartitioner.class);
  job.setGroupingComparatorClass(TextIntPair.FirstComparator.class);

  job.setMapOutputKeyClass(TextIntPair.class);
  job.setMapOutputValueClass(TextLongIntPair.class);
  job.setReducerClass(JoinReducer.class);

  job.setOutputKeyClass(TextIntPair.class);
  job.setOutputValueClass(TextLongPair.class);

  return job.waitForCompletion(true) ? 0 : 1;
    }

    public static int runJob2(String[] args) throws Exception {
  //need first comparator like previous job
  Configuration conf = new Configuration();
      Job job = new Job(conf);

  job.setJarByClass(StockJoinJob.class);
  job.setReducerClass(TotalReducer.class);
      job.setMapperClass(TotalMapper.class);
  Path firstPath = new Path(args[2]+"-first");
  Path outputPath = new Path(args[2]+"-second");

  //reducer output//
  job.setOutputKeyClass(TextIntPair.class);
  job.setOutputValueClass(TextLongPair.class);

  //mapper output//
  job.setMapOutputKeyClass(TextIntPair.class);
  job.setMapOutputValueClass(TextIntPair.class);      

  //etc            
  FileInputFormat.setInputPaths(job, firstPath);
  FileOutputFormat.setOutputPath(job, outputPath);
  outputPath.getFileSystem(conf).delete(outputPath, true);

  return job.waitForCompletion(true) ? 0 : 1;
    }



public static void main(String[] args) throws Exception {
int firstCode = runJob(args);
if(firstCode==0){
 int secondCode =runJob2(args);
  System.exit(secondCode);
 }


 }
 }