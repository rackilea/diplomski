// shuts the pool down but the submitted jobs still run
threadPool.shutdown();
// wait for all of the jobs to finish
threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
// now go back and print out your jobs
for (YourRunnable job : jobs) {
    System.out.println(jobs.toString());
}