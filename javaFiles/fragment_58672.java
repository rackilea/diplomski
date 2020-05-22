public static void main(String[] args) throws URISyntaxException, IOException {
        String host = "https://rally1.rallydev.com";
        String username = "user@co.com";
        String password = "secret";
        String workspaceRef = "/workspace/12352608129"; 
        String applicationName = "RESTExample get team members";

        RallyRestApi restApi = new RallyRestApi(
                new URI(host),
                username,
                password);
        restApi.setApplicationName(applicationName); 
        System.out.println(restApi.getWsapiVersion()); 

        try{
             QueryRequest projectRequest = new QueryRequest("Project");
             projectRequest.setFetch(new Fetch("Name", "TeamMembers"));
             projectRequest.setWorkspace(workspaceRef);
             projectRequest.setQueryFilter(new QueryFilter("Name", "=", "Company X"));

             QueryResponse projectQueryResponse = restApi.query(projectRequest);
             int count = projectQueryResponse.getResults().size();
             System.out.println(count);
             if(count > 0){
                 JsonObject projectObject = projectQueryResponse.getResults().get(count-1).getAsJsonObject();
                 int numberOfTeamMembers = projectObject.getAsJsonObject("TeamMembers").get("Count").getAsInt();
                 if(numberOfTeamMembers > 0) {
                        QueryRequest teamRequest = new QueryRequest(projectObject.getAsJsonObject("TeamMembers"));
                        JsonArray teammates = restApi.query(teamRequest).getResults();
                        for (int j=0;j<numberOfTeamMembers;j++){
                            System.out.println(teammates.get(j).getAsJsonObject().get("_refObjectName").getAsString());
                        }
                    }
             }

        }catch(Exception e){
            e.printStackTrace();

        } finally{
            restApi.close();
        }
    }