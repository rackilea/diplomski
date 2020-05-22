/**
 * Get Process instance diagram
 */
public InputStream getProcessDiagram(String processInstanceId) {
    ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
            .processInstanceId(processInstanceId).singleResult();

    // null check
    if (processInstance != null) {
        // get process model
        BpmnModel model = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());

        if (model != null && model.getLocationMap().size() > 0) {
            ProcessDiagramGenerator generator = new DefaultProcessDiagramGenerator();
            return generator.generateDiagram(model, ActivitiConstants.PROCESS_INSTANCE_IMAGE_FORMAT,
                    runtimeService.getActiveActivityIds(processInstanceId));
        }
    }
    return null;
}