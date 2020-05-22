write.connectionReqeuestTimeout(60000);
write.connectionTimeout(60000);      

//Create headers tree map collection - can specify headers to pass into auth class but we have set mandatory headers in class
TreeMap<String, String> awsHeaders = new TreeMap<String, String>();

 //Create V4 Auth Headers from Auth Class 
awsHeaders.put("host", helper.getSoftlayerEndpoint());
AWSV4Auth aWSV4Auth = new AWSV4Auth.Builder(helper.getAccessorLogsS3Accesskey(), helper.getAccessorLogsS3Secretkey())
        .regionName("us-east-1")
        .serviceName("s3") // es - elastic search. use your service name
        .httpMethodName("GET") //GET, PUT, POST, DELETE, etc...
        .canonicalURI("s3-api.xxxx.xxxx.xxxx.net") //end point
        .queryParametes(null) //query parameters if anyåç
        .awsHeaders(awsHeaders) //aws header parameters
        .payload(null) // payload if any
        .debug() // turn on the debug mode
        .build();

/* Get headers calculated for request */
Map<String, String> header = aWSV4Auth.getHeaders();
for (Map.Entry<String, String> entrySet : header.entrySet()) {
    String key = entrySet.getKey();
    String value = entrySet.getValue();

    write.header(key, value);
    logger.debug("Header is: " + write.header(key, value));
}