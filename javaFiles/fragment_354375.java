ActionInvocation invocation = ActionContext.getContext().getActionInvocation();
ActionProxy proxy = invocation.getProxy();
ActionConfig config = proxy.getConfig();
Map<String, ResultConfig> results = config.getResults();
ResultConfig resultConfig = results.get(Action.SUCCESS);
String lastFinalLocation = null;
Map<String, String> params = resultConfig.getParams();
if (resultConfig.getClassName().equals("org.apache.struts2.dispatcher.ServletDispatcherResult")) {
  lastFinalLocation = params.get("location");
}
System.out.println("location: " + lastFinalLocation);