@Override
public int run(String[] args) throws Exception {
    Configuration conf = getConf();
    Job job = Job.getInstance(conf, APP_NAME);
    job.setJarByClass(StoreSumRunner.class);

    job.setMapperClass(TokenizerMapper.class);
    job.setReducerClass(CurrencyReducer.class);

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(DoubleWritable.class);

    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    return job.waitForCompletion(true) ? 0 : 1;
}

static class TokenizerMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {

    private final Text key = new Text();
    private final DoubleWritable sales = new DoubleWritable();

    @Override
    protected void map(LongWritable offset, Text value, Context context) throws IOException, InterruptedException {
        final String line = value.toString();
        final String[] data = line.trim().split("\\s\\s+");

        if (data.length < 6) {
            System.err.printf("mapper: not enough records for %s%n", Arrays.toString(data));
            return;
        }

        key.set(data[3]);

        try {
            sales.set(Double.parseDouble(data[4]));
            context.write(key, sales);
        } catch (NumberFormatException ex) {
            System.err.printf("mapper: invalid value format %s%n", data[4]);
        }
    }
}

static class CurrencyReducer extends Reducer<Text, DoubleWritable, Text, Text> {
    private final Text output = new Text();
    private final DecimalFormat df = new DecimalFormat("#.00");

    @Override
    protected void reduce(Text date, Iterable<DoubleWritable> values, Context context) throws IOException, InterruptedException {
        double sum = 0;
        for (DoubleWritable value : values) {
            sum += value.get();
        }
        output.set(df.format(sum));
        context.write(date, output);
    }
}