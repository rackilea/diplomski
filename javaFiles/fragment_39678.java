public class Reduce extends Reducer<mytextpairWritable, IntWritable,mytextpairWritable, IntWritable> {


    public void reduce(mytextpairWritable key, Iterable<IntWritable> values , Context context)
    throws IOException, InterruptedException {
        int sum = 0;
        for(IntWritable val: values){
            sum+=val.get();
            }
       context.write(key, new IntWritable(sum));
}