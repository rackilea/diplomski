public void executeRestTestcase() throws Exception {       

    final WsdlProject project = new WsdlProject();
    final RestServiceBuilder serviceBuilder = new RestServiceBuilder();
    serviceBuilder.createRestService(project,"Your Rest URL");
    final StringToStringMap headers = new StringToStringMap();
    headers.put("Authorization", "Basic **********");
    headers.put("Accept", "application/json");
    final RestRequest request =
            (RestRequest) project.getInterfaceList().get(0).getOperationList().get(0).getRequestList().get(0);
    request.setRequestHeaders(headers);
    final Submit submit = (Submit) request.submit(new WsdlSubmitContext(request), false);
    final Response response = submit.getResponse();
    String responseContent = response.getContentAsString();
    log.info(responseContent);


}