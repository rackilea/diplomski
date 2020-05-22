WsdlOperation wsdlOperation=wsdlInterface1.getOperationByName(operationName);
WsdlRequest request = wsdlOperation.addNewRequest("My request");
String requestContent;              
   if(rd.useXmlRequest(artifactId)!=null){ //Verify if exist an xml request for that service
requestContent=rd.useXmlRequest(artifactId); // uses the existing request
   }else{
requestContent = wsdlOperation.createRequest(true); // create a new blank request                       
 }
request.setRequestContent(requestContent); 
WsdlSubmit submit = (WsdlSubmit) request.submit(new WsdlSubmitContext(request), false);