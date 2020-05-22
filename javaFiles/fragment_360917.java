@Subscribe
public void executeJob(jobVO jobVO ) {
    if (!jobVO.getAction().equals("executeJob")) {
       return;
    }
    //logic goes here
}