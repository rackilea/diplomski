AmazonApiGateway amazonApiGateway;

private void putMethod(final RestApi restApi, final Resource resource, final HttpMethod httpMethod) throws AmazonClientException {
    PutMethodRequest putMethodRequest = new PutMethodRequest()
        .withOperationName(METHOD_OPERATION_NAME)
        .withHttpMethod(httpMethod.name())
        .withResourceId(resource.getId())
        .withRestApiId(restApi.getId())
        .withAuthorizationType("NONE");

    amazonApiGateway.putMethod(putMethodRequest);
}

private void putMethodIntegration(final RestApi restApi, final Resource resource, final HttpMethod httpMethod) throws AmazonClientException {
    PutIntegrationRequest putIntegrationRequest = new PutIntegrationRequest()
        .withRestApiId(restApi.getId())
        .withResourceId(resource.getId())
        .withHttpMethod(httpMethod.name())
        .withIntegrationHttpMethod(httpMethod.name())
        .withType(IntegrationType.HTTP);

    amazonApiGateway.putIntegration(putIntegrationRequest);
}

private void putMethodResponse(final RestApi restApi, final Resource resource, final HttpMethod httpMethod, final Map<String, Boolean> methodResponseParameters) throws AmazonClientException {
    amazonApiGateway.putMethodResponse(new PutMethodResponseRequest()
        .withRestApiId(restApi.getId())
        .withResourceId(resource.getId())
        .withHttpMethod(httpMethod.name())
        .withStatusCode("200")
        .withResponseModels(Collections.singletonMap("application/json", "Empty"))
        .withResponseParameters(methodResponseParameters));
}

private void putMethodIntegrationResponse(final RestApi restApi, final Resource resource, final HttpMethod httpMethod, final Map<String, String> parameters) throws AmazonClientException{
    final Map<String, String> dataPassThroughTemplate = new HashMap<>();
    dataPassThroughTemplate.put("application/json", "");

    amazonApiGateway.putIntegrationResponse(new PutIntegrationResponseRequest()
        .withRestApiId(restApi.getId())
        .withResourceId(resource.getId())
        .withHttpMethod(httpMethod.name())
        .withStatusCode("200")
        .withResponseParameters(parameters)
        .withResponseTemplates(dataPassThroughTemplate));
}

private Map<String, Boolean> getMethodResponseParameters() {
    final Map<String, Boolean> methodResponseParameters = new HashMap<>();
    methodResponseParameters.put(String.format(METHOD_RESPONSE_TEMPLATE, "Access-Control-Allow-Origin"), true);
    methodResponseParameters.put(String.format(METHOD_RESPONSE_TEMPLATE, "Access-Control-Allow-Headers"), true);
    methodResponseParameters.put(String.format(METHOD_RESPONSE_TEMPLATE, "Access-Control-Allow-Methods"), true);
    return methodResponseParameters;
}

private Map<String, String> getIntegrationResponseParameters() {
    final Map<String, String> integrationResponseParameters = new HashMap<>();
    integrationResponseParameters.put(String.format(METHOD_RESPONSE_TEMPLATE, "Access-Control-Allow-Origin"), "'*'");
    integrationResponseParameters.put(String.format(METHOD_RESPONSE_TEMPLATE, "Access-Control-Allow-Headers"), "'Content-Type,X-Amz-Date,Authorization,x-api-key,x-amz-security-token'");
    integrationResponseParameters.put(String.format(METHOD_RESPONSE_TEMPLATE, "Access-Control-Allow-Methods"), "'GET,POST,DELETE,PUT,PATCH,OPTIONS'");
    return integrationResponseParameters;
}