public void map(Text key, Text value,OutputCollector<Text, Text> output,
Reporter reporter) throws IOException {
  String temp=new String(value);
  String token[]=temp.split(",");
  output.collect(new Text("max"),new text(token[0]));
  output.collect(new Text("min"),new text(token[1]));
  output.collect(new Text("result"),new text(token[2]));
}

public void reduce(Text key, Iterator<Text> values,
    OutputCollector<Text, Text> output, Reporter reporter)
    throws IOException {
StringBuffer sb=new StringBuffer();
while (values.hasNext())
   sb.append(values.next().toString() + ",");
output.collect(new Text(""),new Text(sb.toString()))



}