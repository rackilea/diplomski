@Override
public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    for (Text value: values){
        if (!first) sb.append(", ");
        else first = false;
        sb.append(value);
    }
    context.write(key, new Text(sb.toString()));
}