public String intercept(ActionInvocation actionInvocation) throws Exception 
{
    Map<String, String[]> parameters = ServletActionContext.getRequest().getParameterMap();  
    String userId  = parameters.get("bean.userId")[0];
    System.out.println("Got it:"+userId);
    return actionInvocation.invoke();
}