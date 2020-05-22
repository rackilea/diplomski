public void run(Context context) throws IOException, InterruptedException {
    setup(context);
    while (context.nextKey()) {
      reduce(context.getCurrentKey(), context.getValues(), context);
    }
    context.write(new LongWritable(max),new Text("")); // write the max value
    cleanup(context);
  }