public class MyTextOutputFormat extends FileOutputFormat<Text, List<IntWritable>> {
      @Override
      public org.apache.hadoop.mapreduce.RecordWriter<Text, List<Intwritable>> getRecordWriter(TaskAttemptContext arg0) throws IOException, InterruptedException {
         //get the current path
         Path path = FileOutputFormat.getOutputPath(arg0);
         //create the full path with the output directory plus our filename
         Path fullPath = new Path(path, "result.txt");
     //create the file in the file system
     FileSystem fs = path.getFileSystem(arg0.getConfiguration());
     FSDataOutputStream fileOut = fs.create(fullPath, arg0);

     //create our record writer with the new file
     return new MyCustomRecordWriter(fileOut);
  }
}

public class MyCustomRecordWriter extends RecordWriter<Text, List<IntWritable>> {
    private DataOutputStream out;

    public MyCustomRecordWriter(DataOutputStream stream) {
        out = stream;
        try {
            out.writeBytes("results:\r\n");
        }
        catch (Exception ex) {
        }  
    }

    @Override
    public void close(TaskAttemptContext arg0) throws IOException, InterruptedException {
        //close our file
        out.close();
    }

    @Override
    public void write(Text arg0, List arg1) throws IOException, InterruptedException {
        //write out our key
        out.writeBytes(arg0.toString() + ": ");
        //loop through all values associated with our key and write them with commas between
        for (int i=0; i<arg1.size(); i++) {
            if (i>0)
                out.writeBytes(",");
            out.writeBytes(String.valueOf(arg1.get(i)));
        }
        out.writeBytes("\r\n");  
    }
}