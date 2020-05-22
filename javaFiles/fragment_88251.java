try {
        configuration.set("fs.defaultFS", "hdfs://127.0.0.1:9000");
        configuration.set("mapreduce.jobtracker.address", "localhost:54311");
        configuration.set("mapreduce.framework.name", "yarn");
        configuration.set("yarn.resourcemanager.address", "localhost:8032");

        Job job = createJob(configuration);
        job.waitForCompletion(true);
    } catch (Exception e) {
        logger.log(Level.SEVERE, "Unable to execute job", e);
    }