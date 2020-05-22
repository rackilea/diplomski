public class LambdaFunctionHandler implements RequestHandler<Object, Object> {

    @Override
    public Object handleRequest(AwsProxyRequest input, Context context) {
        String resourcePath = input.getRequestContext().getResourcePath();

        return resourcePath;
    }

}

public class AwsProxyRequest {

    //-------------------------------------------------------------
    // Variables - Private
    //-------------------------------------------------------------
    private ApiGatewayRequestContext requestContext;
    ....

    //-------------------------------------------------------------
    // Methods - Getter/Setter
    //-------------------------------------------------------------

    public ApiGatewayRequestContext getRequestContext() {
        return requestContext;
    }


    public void setRequestContext(ApiGatewayRequestContext requestContext) {
        this.requestContext = requestContext;
    }

    ....

}

public class ApiGatewayRequestContext {

    //-------------------------------------------------------------
    // Variables - Private
    //-------------------------------------------------------------

    private String resourcePath;
    ...

    //-------------------------------------------------------------
    // Methods - Getter/Setter
    //-------------------------------------------------------------

    public String getResourcePath() {
        return resourcePath;
    }


    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    ....
}