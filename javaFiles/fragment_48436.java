// Active tasks for currently running instanceId(input to below code)
 List<Task> tasks = this.taskService.createTaskQuery().processInstanceId(instanceId).list();

 String documentation= null;

for (Task task : tasks)
{
//This gives [documentation][1] field.
documentation = task.getDescription();

UserTaskImpl modelElementById = (UserTaskImpl) bpmnModelInstance.getModelElementById(tasks.get(0)
    .getTaskDefinitionKey());
ExtensionElements childElementsByType2 = modelElementById.getExtensionElements();
Collection<ModelElementInstance> elements = childElementsByType2.getElements();
for (ModelElementInstance elem : elements)
{
    //To access all properties.
    if (elem instanceof CamundaPropertiesImpl)
    {
        CamundaPropertiesImpl camundaPropertiesImpl = (CamundaPropertiesImpl) elem;
        Collection<CamundaProperty> camundaProperties = camundaPropertiesImpl.getCamundaProperties();
        for (CamundaProperty test : camundaProperties)
        {
            System.out.println("camunda property name :" + test.getCamundaName() + " $ " + test.getCamundaValue());
        }

    }
    else if (elem instanceof CamundaInputOutputImpl)
    {
        // To access input/output param
        CamundaInputOutputImpl camundaInputOutputImpl = (CamundaInputOutputImpl) elem;
        for (CamundaInputParameter test : camundaInputOutputImpl.getCamundaInputParameters())
        {
            log.info("camunda input params name :" + test.getCamundaName() + " $ " + test.getTextContent());
        }
        for (CamundaOutputParameter test : camundaInputOutputImpl.getCamundaOutputParameters())
        {
            log.info("camunda output params name :" + test.getCamundaName() + " $ " + test.getTextContent());
        }
    }
 }
}