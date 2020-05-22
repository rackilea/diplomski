public class LambdaImageTest {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        String bucketName = args[0]; 
        String key        = args[1]; 

        // Lambda client proxy
        AWSLambdaClient lambda = new AWSLambdaClient(new ProfileCredentialsProvider());
        lambda.configureRegion(Regions.EU_WEST_1);

        // Build InvokeRequest
        InvokeRequest invokeRequest = buildInvokeRequest("ImageProcessing",  
                new ImageRequest(bucketName, key));

        // Invoke and get result payload as ByteBuffer. Note error handling should be done here
        InvokeResult invokeResult = lambda.invoke(invokeRequest);
        ByteBuffer byteBuffer = invokeResult.getPayload();

        // Write payload to file. Output hardcoded...
        FileChannel out = new FileOutputStream("D:/test.jpg").getChannel(); 
        out.write(byteBuffer);
        out.close();
    }

    private static InvokeRequest buildInvokeRequest(String functionName, Object input) {

        InvokeRequest invokeRequest = new InvokeRequest();
        invokeRequest.setFunctionName(functionName); // Lambda function name identifier
        invokeRequest.setInvocationType(InvocationType.RequestResponse);
        invokeRequest.setLogType(LogType.None);

        if (input != null) {
            try {

                String payload = MAPPER.writer().writeValueAsString(input);
                invokeRequest.setPayload(payload);

            } catch (JsonProcessingException ex) {
                throw new LambdaSerializationException("Failed to serialize request object to JSON", ex);
            }
        }

        return invokeRequest;
    }
}