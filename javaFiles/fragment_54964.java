public static class HeaderParserMapper
        extends Mapper<LongWritable, Text , Text, NullWritable>{

    String[] headerList;
    String header;

    @Override
    protected void setup(Mapper.Context context) throws IOException, InterruptedException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("header.txt"));
        header = bufferedReader.readLine();
        headerList = header.split(",");
    }

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String line = value.toString();
        String[] values = line.split(",");

        if(headerList.length == values.length && !header.equals(line)) {
            for(int i = 0; i < values.length; i++)
                context.write(new Text(headerList[i] + "," + values[i]), NullWritable.get());
        }
    }
}