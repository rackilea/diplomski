public interface JobHistoryRepository extends CrudRepository<JobHistory, Long> {

    List<JobHistory> findByJobGroup(String jobGroup);
    JobHistory findById (Integer id);
    List<JobHistory> findByStateAndJobGroup(String state, String jobGroup);
    JobHistory findByJobNameAndJobGroupAndIdTrigger (String jobName, String jobGroup, String idTrigger);
}