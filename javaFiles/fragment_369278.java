final DateTime selfOrderDate = (DateTime) execution.getVariable(PROCESS_ORDER_DATE);

List<ProcessInstance> processInstanceList = execution
        .getProcessEngineServices()
        .getRuntimeService()
        .createProcessInstanceQuery()
        .processDefinitionId(execution.getProcessDefinitionId())
        .variableValueEquals(CUSTOMER_ID, execution.getVariable(CUSTOMER_ID))
        .active()
        .list();

int processesOrderedBeforeCurrentCount = 0;
for (ProcessInstance processInstance : processInstanceList) {
    ExecutionEntity entity = (ExecutionEntity) processInstance;

    if (processInstance.getId().equals(execution.getId()))
        continue;

    DateTime orderDate = (DateTime) entity.getVariable(PROCESS_ORDER_DATE);
    if (selfOrderDate.isAfter(orderDate)) {
        processesOrderedBeforeCurrentCount += 1;
    }
}