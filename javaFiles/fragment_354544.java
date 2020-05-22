Region region;
    AWSLambdaClient lambdaClient;

    lambdaClient = new AWSLambdaClient(new DefaultAWSCredentialsProviderChain());
    region = Region.getRegion(Regions.fromName(regionName));
    lambdaClient.setRegion(region);

    InvokeRequest invokeRequest = new InvokeRequest();
    invokeRequest.setFunctionName(FunctionName);
    invokeRequest.setPayload(ipInput);


    returnDetails = byteBufferToString(
            lambdaClient.invoke(invokeRequest).getPayload(),
            Charset.forName("UTF-8"),logger);