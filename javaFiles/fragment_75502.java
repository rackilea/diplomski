public static class MapForWordCount extends Mapper<LongWritable, Text, Text, FloatWritable>{

public void map(LongWritable key, Text value, Context con) throws IOException, InterruptedException

{

String line = value.toString();

String[] words=line.split(",");

Text outputKey = new Text(words[0]);


if (words != null && words[0].length() > 0) {
    try {
        FloatWritable outputValue = new FloatWritable(Float.parseFloat(words[8]));
        con.write(outputKey, outputValue);
    } catch(Exception e) {             
    }
}    
}    
}