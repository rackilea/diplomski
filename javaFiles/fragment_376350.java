public static class Reduce extends Reducer<Text, IntWritable, Text, Text> {
    Text emitValue = new Text()
    public void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        int sum = 0;
        int visitsCounter = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        float avg;
        for (IntWritable val : values) {
            int currentValue = val.get();
            sum += currentValue;
            visitsCounter++;
            min = Math.min(min, currentValue);
            max = Math.max(max, currentValue);
        }
        avg = sum / visitsCounter;
        String myValue = min + "\t" + max + "\t" + avg;
        emitValue.set(myValue);
        //here can be the supposed edit to let me output (user - min - max - avg )
        context.write(key, emitValue);
    }
}