private final Runtime rt = Runtime.getRuntime();

public void map(Object key, Text value, Context context
                ) throws IOException, InterruptedException {
    String command = "evm --debug --code " + value.toString() + " run";
    Process proc = rt.exec(command);

    context.write( ... some_key, some_value ...);
}