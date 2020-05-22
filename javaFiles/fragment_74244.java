BpmnModel model = processEngine.getRepositoryService().getBpmnModel(someProcessId);
List<Process> processes = model.getProcesses();
List<UserTask> userTasks = new ArrayList<>();
for( Process p : processes ) {
     userTasks.addAll( p.findFlowElementsOfType(UserTask.class))    
}