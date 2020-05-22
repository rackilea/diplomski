public class CustomWindowFunction implements RichAllWindowFunction<String, String, TimeWindow> {

    private Connection database;

    @Override
    public void open(Configuration parameters) {
        database = new Connection();
    }

    @Override
    public void apply(TimeWindow timeWindow, Iterable<String> trades, Collector<String> out) {
        // process data
        database.save(data);
        out.collect(data.toString());
    }
}