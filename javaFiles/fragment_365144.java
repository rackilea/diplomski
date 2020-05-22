public void setup(Context context) {
   out = new MultipleOutputs(context);
   ...
}

public void reduce(Text key, Iterable values, Context context) throws IOException,           InterruptedException {
  for (Text t : values) {
    out.write(key, t, generateFileName(<parameter list...>));
    // generateFileName is your function
  }
}

protected void cleanup(Context context) throws IOException, InterruptedException {
  out.close();
}