public static class Reduce extends Reducer<Text, Text, Text, Text> {

    Text valueToEmit = new Text();

    public void reduce(Text key, Iterable<Text> values, Context context)
    throws IOException, InterruptedException {
        StringBuilder sb = new StringBuilder();
        for(Text x : values)
        {
            sb.append(x.toString()).append(",");
        }

        valueToEmit.set(sb.substring(0,sb.length()-1)); //to remove the last ','
        context.write(key, valueToEmit);
    } 
}