private final Text text = new Text();

public void map(Text key, Text value, Context context) {
    ....
    for (String split : splits) {
        text.set(split);
        context.write(key, text);
    }
}