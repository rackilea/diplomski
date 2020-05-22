protected OutputCollector<NullWritable, Text> collector = null;
protected String filename = null;

@Override
public void configure(JobConf conf) {
    this.conf = conf;
    mos = new MultipleOutputs(conf);

    // get the filename (just the name, not the path)
    filename = new Path(conf.get("map.input.file")).getName();        
}

public void map(LongWritable key, Text value,
    OutputCollector<NullWritable, Text> output, Reporter reporter)
    throws IOException {

    try {
        if (collector == null) {
            // create an output collector for the file
            collector = mos.getCollector("mofiles", filename, reporter);
        }

        collector.collect(NullWritable.get(), value);
    } catch (ArrayIndexOutOfBoundsException E) {
        E.printStackTrace();
    } catch (Exception E) {
        System.out.println(line);
        E.printStackTrace();
    }
}

@Override
public void close() throws IOException {
    mos.close();
}