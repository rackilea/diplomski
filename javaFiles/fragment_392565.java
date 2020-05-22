public class AwesomeHandler implements WorkItemHandler {

    public AwesomeHandler() {
        super();
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
        System.out.println("Executing Awesome handler");
        manager.completeWorkItem(workItem.getId(), null);
    }

    public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
        System.out.println("Aborting");
    }
}