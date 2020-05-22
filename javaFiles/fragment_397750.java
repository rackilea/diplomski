public int run(String args[]) {
    Configuration conf = getConf();

    String env1 = conf.get("env1");
    String env2 = conf.get("env2");

    Job job = new Job(conf, "MR Job");
    job.setJarByClass(MRDriver.class);

    /*...*/
}