@GET
    @Path("/GetFeeds")
    @Produces("application/json")
    public String feed(@QueryParam("id") String id) {
        String feeds = null;
        try {
            ArrayList<FeedObjects> feedData = null;
            ProjectManager projectManager = new ProjectManager();
            // Modify the GetFeeds method by sending the value of id
            // and prepare feed data based on id
            feedData = projectManager.GetFeeds(id);
            Gson gson = new Gson();
            // create the json data for the feed data of the corresponding id value
            feeds = gson.toJson(feedData);

        } catch (Exception e) {
            System.out.println("error");
        }
        return feeds;

   }