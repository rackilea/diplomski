public static class WLReducer2 extends
        Reducer<IntWritable, Text, Text, IntWritable> {
    int count=0;
    @Override
    protected void reduce(IntWritable key, Iterable<Text> values,
            Context context) throws IOException, InterruptedException {

        for (Text x : values) {
            if (count < 5)
            context.write(key, x);
            count++;
        }

    };
}