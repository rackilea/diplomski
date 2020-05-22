private void getNumber(){
AXLAPIService axlService = new AXLAPIService();
AXLPort axlPort = axlService.getAXLPort();

String validatorUrl = "https://mycucm:8443/axl/";

((BindingProvider) axlPort).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, validatorUrl);
((BindingProvider) axlPort).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, Demo.ucAdmin);
((BindingProvider) axlPort).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, Demo.ucPswd);


GetLineReq axlParams = new GetLineReq();
ObjectFactory objectFactory = new ObjectFactory(); //This is new

XFkType routePartition = new XFkType(); 
routePartition.setValue("PHONES");     // This is where you specify your route partition name

axlParams.setPattern("7491817");
axlParams.setRoutePartitionName(objectFactory.createGetLineReqRoutePartitionName(routePartition));


GetLineRes getLineResponse = axlPort.getLine(axlParams);


Demo.informUser("Line Information: \n" 
        + "Alerting Name: " + getLineResponse.getReturn().getLine().getAlertingName() + "\n" 
        + "Dial Number: " + getLineResponse.getReturn().getLine().getPattern() + "\n" 
        + "Description: " + getLineResponse.getReturn().getLine().getDescription() + "\n"
        + " " + getLineResponse.getReturn().getLine().getShareLineAppearanceCssName());
}