@Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            FileSystem fs = FileSystem.get(context.getConfiguration());
            for (FileStatus status : fs.listStatus(new Path(value.toString()))) {
                // process file
            }
        }