public void map(Text key, Text value, Context context) {
    String dataToSplit = value.toString();
    String delim = ":";

    int beginIndex = 0;
    int endIndex = 0;

    while(true) {
        endIndex = dataToSplit.indexOf(delim, beginIndex);
        if(endIndex == -1) {
            text.set(dataToSplit.substring(beginIndex));
            context.write(key, text);
            break;
        }

        text.set(dataToSplit.substring(beginIndex, endIndex));
        context.write(key, text);
        beginIndex = endIndex + delim.length();
    }
}