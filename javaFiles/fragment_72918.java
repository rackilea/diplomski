// get the application Context
ApplicationContext context = getApplicationContext();
// get webflowController, must be configured in your webflowConfig file
FlowController controller = (FlowController)context.getBean("flowController");
FlowExecutorImpl flowExecutorImpl = (FlowExecutorImpl)controller.getFlowExecutor();
FlowDefinitionRegistryImpl flowDefinitionRegistryImpl = (FlowDefinitionRegistryImpl)flowExecutorImpl.getDefinitionLocator();

// flowId is the id of the flow you want to check
FlowDefinition flowDefinition = flowDefinitionRegistryImpl.getFlowDefinition(flowId);

MutableAttributeMap<Object> attributes = flowDefinition.getAttributes();

// finally the SecurityRule Object that you can pass to a specific AccessDecisionManager
SecurityRule securityRule = (SecurityRule)attributes.get("secured");