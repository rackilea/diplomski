public static void main(String[] args) {

    String systemName = "my_system_name";
    String jobName = "job_name";
    String userName = "user_name";
    String jobNumber = "job_number";

try {
    AS400 system = new AS400 (systemName);

    // Get this specific job
    Job job = new Job(system, jobName, userName, jobNumber);
    System.out.println("Name " + job.getName() + " | Job NO : " + job.getNumber() + " | User : " + job.getUser() + " | CPU USED : " + job.getCPUUsed());

    // Create a list and subset it
    JobList jobList = new JobList(system);
    jobList.clearJobSelectionCriteria();
    jobList.addJobSelectionCriteria(JobList.SELECTION_JOB_NUMBER, jobNumber);
    Enumeration list = jobList.getJobs();
    while (list.hasMoreElements())  {
        Job  j= (Job) list.nextElement();
        String GCPU = Integer.toString(j.getCPUUsed());
        System.out.println("Name " + j.getName() + " | Job NO : " + j.getNumber() + " | User : " + j.getUser() + " | CPU USED : " + j.getCPUUsed());
        }

    } catch (Exception e) {
        System.out.println(e);
    }

}