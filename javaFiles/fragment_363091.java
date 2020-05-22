CreateRequest createRequest = new CreateRequest(query, object);

    createRequest.addParam("workspace", "/workspace/1333333333");

    CreateResponse createResponse = restApi.create(createRequest);

    return createResponse;