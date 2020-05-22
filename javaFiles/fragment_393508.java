public static ApiResponse uploadFileToServer(){
    File file = new File("your asset path");
    Map<String, Object> dataParams = new HashMap<String, Object>();
    data.put("name", <file_name>);
    data.put("file", file);
    //here type and name are necessary to create entity
    data.put("type", <collection_name>);
    data.put("name", <entity_name>);
    //entity_name will be the name of your new created entity.
    Client client = new Client(<organization_name>, <application_name>);
    client.setApiUrl(<url to hit>);
    client.authorizeAppUser(<username>, <password>);
    client.createEntity(dataParams);
    String <uri> = <collection_name> + "/" + <entity_name>;
    ApiResponse response = client.httpRequest(HttpMethod.POST,ApiResponse.class, null, dataParams, <organization_name>, <application_name>,
            <uri>);
    return response;
    }