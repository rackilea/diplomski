import org.apache.log4j.Logger;
// other imports omitted

public class SampleMapper extends Mapper<LongWritable, Text, Text, Text> {
    private Logger logger = Logger.getLogger(SampleMapper.class);

    @Override
    protected void setup(Context context) {
        logger.info("Initializing NoSQL Connection.")
        try {
            // logic for connecting to NoSQL - ommitted
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // mapper code ommitted
    }
}