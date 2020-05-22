@Override
    public void setup(Context context) throws IOException, InterruptedException{
        Configuration conf = context.getConfiguration();
        Cluster cluster = new Cluster(conf);
        Job currentJob = cluster.getJob(context.getJobID());
        mapperCounter = currentJob.getCounters().findCounter(COUNTER_NAME).getValue();  
    }