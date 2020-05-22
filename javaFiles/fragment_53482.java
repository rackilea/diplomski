package org.camunda.bpm;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import java.util.List;

public class AllFinishedProcessInstances {

  public List<HistoricProcessInstance> getAllFinishedProcessInstances(String processDefinitionName) {
    ProcessEngine processEngine = BpmPlatform.getDefaultProcessEngine();
    HistoryService historyService = processEngine.getHistoryService();;
    RepositoryService repositoryService = processEngine.getRepositoryService();

    ProcessDefinition myProcessDefinition =
        repositoryService.createProcessDefinitionQuery()
            .processDefinitionName(processDefinitionName)
            .latestVersion() // we are only interested in the latest version
            .singleResult();

    List<HistoricProcessInstance> processInstances =
        historyService.createHistoricProcessInstanceQuery()
            .processDefinitionId(myProcessDefinition.getId())
            .finished() // we only want the finished process instances
            .list();

    return processInstances;
  }

}