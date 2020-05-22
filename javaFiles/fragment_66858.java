import static org.quartz.JobBuilder.*;

...

JobDetail job = newJob(MyJob.class)
           .withIdentity("myJob", "group1")
           .requestRecovery(true) //This is the guy!
           .build();

...