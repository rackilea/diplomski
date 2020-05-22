public static class MyReduce extends Reducer<Text, DoubleWritable, Text,DoubleWritable> {

    public void reduce(Text key, Iterator<DoubleWritable> values, Context context) 
      throws IOException, InterruptedException {

        for (DoubleWritable val : values) {
             if (val.get() > 10.0) {
                 context.write(key, val);
             }
        }
    }
}