@Override
public void reduce(Key_class key, Iterator<some_class> values,
    OutputCollector<Text, Text> output, Reporter reporter)
            throws IOException {
  if(this.output==null){
    this.output=output;
  }

  // you should out the arraylist to avoid unexpected behaviour and OOME
  temp.clear();

  while(values.hasNext())
  {
    // you'll need a copy of the configuration - conf
    temp.add(
        ReflectionUtils.copy(conf, values.next(), new some_class()));
  }
}