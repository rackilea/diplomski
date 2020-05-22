public static int run(Configuration conf, Tool tool, String[] args)
        throws Exception{
    if(conf == null) {
        conf = new Configuration();
    }
    GenericOptionsParser parser = getParser(conf, args);

    tool.setConf(conf);

    //get the args w/o generic hadoop args
    String[] toolArgs = parser.getRemainingArgs();
    return tool.run(toolArgs);
}

private static synchronized GenericOptionsParser getParser(Configuration conf, String[] args) throws Exception {
    return new GenericOptionsParser(conf, args);
}