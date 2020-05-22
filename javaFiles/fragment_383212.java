public void reduce(Text key, Iterator<Text> values,
                OutputCollector<Text, Text> output, Reporter reporter) {
  boolean firstKey = true;
  for (Text value : values) {
    output.collect(firstKey ? key : null, value);
    firstKey = false;
  }
}