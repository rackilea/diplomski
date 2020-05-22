@Configuration
public class SpringBatchTestConfiguration
{
@Bean
public static JobLauncherTestUtils jobLauncherTestUtilsForSnapshot()
{
    return new SnapshotJobLauncherTestUtils();
}

public static class SnapshotJobLauncherTestUtils extends JobLauncherTestUtils
{
    @Override
    @Qualifier( "generateMetricsSnapshotJob" )
    public void setJob( final Job job )
    {
        super.setJob( job );
    }
}
}