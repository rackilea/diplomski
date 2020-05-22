AmazonHttpClient client = new AmazonHttpClient(new ClientConfiguration());

Response<AmazonWebServiceResponse<String>> response = client
        .requestExecutionBuilder()
        .request(request)
        .executionContext(context)
        .execute(new StringResponseHandler()) //note the new handler
        .execute()
;

//print the result (string expected)
System.out.println("aws response result = " + response.getAwsResponse().getResult();