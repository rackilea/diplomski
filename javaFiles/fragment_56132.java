public class LegionInputFormat extends InputFormat<LegionRecordReader> {

    @Override
    protected RecordReader<NullWritable, LegionRecord> constructRecordReader(byte[] recordDelimiterBytes) {
        return new LegionRecordReader(recordDelimiterBytes);
    }

}