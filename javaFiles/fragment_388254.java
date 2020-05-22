@ServiceActivator
public JobLaunchRequest adapt(File file) throws NoSuchJobException {

    JobParameters jobParameters = new JobParametersBuilder().addString(
            "input.file", file.getAbsolutePath()).toJobParameters();

    return new JobLaunchRequest(job, jobParameters);
}