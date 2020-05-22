public class JobResolver{

    private Job job;

    public JobResolver(Job job){
         this.job = job;
    }   

    public fillWithBasicData(JobContainer, SelectedLogin){
        if (jobContainer.getApp().equals(App.TEST)) {
           if (job instanceof JobDTO) {
             ((JobDTO) job).setLoginId(selectedLogin.getId());
             ((JobDTO) job).setZoneId(jobContainer.getZoneId());
           }

           if (job instanceof JobAutoDTO) {
             ((JobAutoDTO) job).setLogin(selectedLogin.getId());
             if(selectedLogin.getConnector() != null ){
                   ((JobAutoDTO) job).setConnectorId(selectedLogin.getConnector().getId());
             }
           }
        }
    }
}