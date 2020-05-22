@Override
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        String movies;

        for (Text value : values) {
            movies += value.toString() + " ";
        }
        context.write(key, new Text(movies));
    }