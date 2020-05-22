import org.camunda.bpm.ProcessEngineService;
import org.camunda.bpm.container.RuntimeContainerDelegate;
import org.camunda.bpm.engine.ManagementService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.management.JobDefinition;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.Job;

import java.util.HashMap;
import java.util.List;

public class StackOverflow {

  public HashMap<ProcessDefinition, List<Job>> queryNextScheduledExecutionOfTimers() {
    ProcessEngineService processEngineService = 
    RuntimeContainerDelegate.INSTANCE.get().getProcessEngineService();
    ProcessEngine defaultProcessEngine = processEngineService.getDefaultProcessEngine();

    // optional step - get all active process definitions
    RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
    List<ProcessDefinition> processDefinitions =
        repositoryService.createProcessDefinitionQuery().active().list();

    ManagementService managementService = defaultProcessEngine.getManagementService();

    HashMap<ProcessDefinition,List<Job>> timerJobsByProcessDefinition = new HashMap<ProcessDefinition, List<Job>>();
    for (ProcessDefinition processDefinition : processDefinitions) {
      List<JobDefinition> jobDefinitions =
          managementService.createJobDefinitionQuery()
              .active()
              .processDefinitionId(processDefinition.getId())
              .list();

      for (JobDefinition jobDefinition : jobDefinitions) {
        // if you want to lookup the activity to highlight it inside the process diagram for example
        String activityId = jobDefinition.getActivityId();
        // if you want to display the configured expression / date / cron expression when the timer should fire
        String jobConfiguration = jobDefinition.getJobConfiguration();
        // if you want to distinguish between timer start event / catching timer intermediate event / boundary timer event
        String timerType = jobDefinition.getJobType();

        List<Job> jobs = managementService.createJobQuery()
            .active()
            .timers()
            .jobDefinitionId(jobDefinition.getId())
            .orderByJobDuedate()
            .list();

        timerJobsByProcessDefinition.put(processDefinition, jobs);
      }
    }

    return timerJobsByProcessDefinition;
  }
}