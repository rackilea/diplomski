public void run(Context context) throws IOException, InterruptedException {

    setup(context); // This is the counterpart of configure() from older API

    while (context.nextKey()) {
        reduce(context.getCurrentKey(), context.getValues(), context);
    }
    cleanup(context);
}