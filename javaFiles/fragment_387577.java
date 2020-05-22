public class WordCountMapper extends Mapper<LongWritable,Text,Text,IntWritable>
{
    protected void map(LongWritablekey,Textvalue,Context context) throws IOException,InterruptedException
    {
        String words[]=value.toString().split(",");
        for(String word:words)
            context.write(new Text(word),new IntWritable(1));
    }
}