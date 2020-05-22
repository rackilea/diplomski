private long someCount;

@Override
protected void setup(Context context) throws IOException,
    InterruptedException {
  super.setup(context);
  this.someCount  = context.getConfiguration().getLong(CountersClass.N_COUNTERS.SOMECOUNT.name(), 0));
}