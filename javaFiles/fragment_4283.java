public class ProcessInstanceHistory {

@Inject
HistoryService historyService;

public List<HistoricProcessInstance> historicProcessInstances() {
    return historyService.createHistoricProcessInstanceQuery().list();
}

public void printDurations() {
    for (HistoricProcessInstance historicProcessInstance : historicProcessInstances()) {
        System.out.println("elapsedTime :" + historicProcessInstance.getDurationInMillis());
    }
}
}