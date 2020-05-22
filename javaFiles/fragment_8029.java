public class BAPJob implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {

        System.out.println("EXECUTION STARTING ...");

        try {
            InternetAddress.parse("to-email@gmail.com");
        } catch (Throwable t) {
            t.printStackTrace();
        }

        System.out.println("EXECUTION ENDING");
    }

}