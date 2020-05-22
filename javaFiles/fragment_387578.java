public class WordCountReducer extends Reducer<Text,IntWritable,IntWritable,IntWritable>
    {
    protected void reduce(Text word,Iterable<IntWritable>values,Context context) throws IOException,InterruptedException
        {
            int count=0,len;
            for(IntWritableval:values)
                count+=val.get();
            context.write(new IntWritable(word.toString().length()),new IntWritable(count));
        }
    }