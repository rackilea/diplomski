public class RawKafka {

private static final Logger LOG = LoggerFactory.getLogger(RawKafka.class);

public static void main(String[] args) throws Exception {
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

    ParameterTool parameterTool = ParameterTool.fromArgs(args);
    DataStream<byte[]> dataStream4 = env.addSource(new FlinkKafkaConsumer081<>("data_4", new RawSchema(), parameterTool.getProperties())).setParallelism(1);

    dataStream4.flatMap(new FlatMapFunction<byte[], Integer>() {
        long received = 0;
        long logfreq = 50000;
        long lastLog = -1;
        long lastElements = 0;

        @Override
        public void flatMap(byte[] element, Collector<Integer> collector) throws Exception {
            received++;
            if (received % logfreq == 0) {
                // throughput over entire time
                long now = System.currentTimeMillis();

                // throughput for the last "logfreq" elements
                if(lastLog == -1) {
                    // init (the first)
                    lastLog = now;
                    lastElements = received;
                } else {
                    long timeDiff = now - lastLog;
                    long elementDiff = received - lastElements;
                    double ex = (1000/(double)timeDiff);
                    LOG.info("During the last {} ms, we received {} elements. That's {} elements/second/core. GB received {}",
                            timeDiff, elementDiff, elementDiff*ex, (received * 2500) / 1024 / 1024 / 1024);
                    // reinit
                    lastLog = now;
                    lastElements = received;
                }
            }
        }
    });

    env.execute("Raw kafka throughput");
}
}