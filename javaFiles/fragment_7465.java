dataStream.flatMap(new FlatMapFunction<String, String>() {
@Override
public void flatMap(String value, Collector<String> out)
    throws Exception {
    for(String word: value.split(" ")){
        out.collect(word);
    }
}
});