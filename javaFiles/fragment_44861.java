public class MyLambdaFunctionHandler implements RequestHandler<String, String>, ApplicationContextAware {

    public MyLambdaFunctionHandler() {
    }

    private ApplicationContext springContext;
    private MyServices myServices;

    public String handleRequest(String input, Context lambdaContext) {
        this.myServices = springContext.getBean(MyServices.class);
        lambdaContext.getLogger().log("AWS Request ID: " + lambdaContext.getAwsRequestId());
        lambdaContext.getLogger().log("Input: " + input + " at " + Calendar.getInstance().getTimeInMillis());
        myServices.sendGoodMessage("Message sent from Lambda");
        return "Hello World";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.springContext = applicationContext;
    }
}