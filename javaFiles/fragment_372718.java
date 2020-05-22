public class JobContainerResolver{

   private JobContainer jobContainer;

   public JobContainerResolver(JobContainer jobContainer){
        this.jobContainer = jobContainer;
   }

   public void fillWithTabData(Tab tab){
        jobContainer.setUser(tab.getUsername());
        jobContainer.setServer(tab.getConnectorURL());
        jobContainer.setPlatform(tab.getPlatform());
   }

   public void fillWithJobData(Job job){
       jobContainer.setJobXYZasJSON(job.toJson());
       jobContainer.setWorker(job.getWorker());
   }

   public void fillWithIds(SelectedLogin login, Integer savedID){
        jobContainer.setId(savedID);
        jobContainer.setLoginID(selectedLogin.getId());
   }

}