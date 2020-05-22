public abstract class InputFormat<T extends RecordReader<NullWritable, LegionRecord>>
        extends FileInputFormat<NullWritable, LegionRecord> {

    private byte[] recordDelimiterBytes;

    @Override
    public RecordReader<NullWritable, LegionRecord> createRecordReader(InputSplit split, TaskAttemptContext context) {

        /* Skipped code for getting recordDelimiterBytes */

        return constructRecordReader(recordDelimiterBytes);
    }

    // factory method for T objects
    protected abstract RecordReader<NullWritable, LegionRecord> constructRecordReader(byte[] recordDelimiterBytes);
}