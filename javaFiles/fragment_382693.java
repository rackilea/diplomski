static boolean isRunning = true;
static boolean isJobsRunning = false;

@SuppressWarnings("static-access")
public static void start(String []args) {
    String command = "run.bat";
    System.out.println("Started JobServices successfully");
    while(isRunning){
        if(!isJobsRunning) { //the job should run only once after the service is started
            try {
                System.out.println("Running batch file");
                Runtime.getRuntime().exec(command);
                isJobsRunning = true;
                System.out.println("Executed batch file successfully");
            } catch (IOException e) {
                System.err.println("Unable to execute Jobs jar");
                e.printStackTrace();
            }
        }
    }
    System.out.println("Completed JobService");

}

public static void stop(String args[]) {
     if(!isRunning) 
         return;

     isRunning = false;
     System.out.println("JobService Stopped successfully");
}