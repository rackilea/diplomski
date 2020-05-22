public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

    String line = value.toString();

    if (line.contains("extract")) {
         context.write(value,null);
    }

}