@Test
public void testLocalRun() throws IOException, InterruptedException, ClassNotFoundException {
    Job job = new Job();
    job.setInputFormatClass(TextInputFormat.class);
    FileInputFormat.setInputPaths(job,
            "src/test/java/csw/hadoop/sandbox/LocalHadoopTest.java");
    job.setOutputFormatClass(TextOutputFormat.class);
    TextOutputFormat.setOutputPath(job, new Path(
            "target/hadoop-local-output"));

    job.setNumReduceTasks(0);

    job.waitForCompletion(true);
}