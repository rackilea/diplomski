public static String query_for_workspace(String ws, RallyRestApi r) throws IOException{

    String Wspace_ref=null;
    //Read Subscription
    QueryRequest subscriptionRequest = new QueryRequest("Subscriptions");

    QueryResponse subscriptionQueryResponse = r.query(subscriptionRequest);
    String subName = subscriptionQueryResponse.getResults().get(0).getAsJsonObject().get("Name").toString();
    System.out.println("Read Subscription: " + subName);

    //Grab Workspaces Collection
    QueryRequest workspaceRequest = new QueryRequest(subscriptionQueryResponse.getResults().get(0).getAsJsonObject().getAsJsonObject("Workspaces"));
    workspaceRequest.setFetch(new Fetch("Name", "_ref”));

    JsonArray myWorkspaces = r.query(workspaceRequest).getResults();

    //Iterate through the Workspaces to find the correct one
    String workspaceName = "";

    for (int i=0; i<myWorkspaces.size(); i++){
        workspaceName = myWorkspaces.get(i).getAsJsonObject().get("Name").getAsString();
        if(workspaceName.equals(ws)){
            System.out.printf("Workspace found ==> %s\n", workspaceName);
            Wspace_ref = myWorkspaces.get(i).getAsJsonObject().get("_ref").getAsString();
        }
    }
    return Wspace_ref;
}