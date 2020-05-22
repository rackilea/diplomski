public static SearchResponse getSearchResponseFromJson(String jsonResponse){
        try {
            NamedXContentRegistry registry = new 
            NamedXContentRegistry(DashboardCuke.getDefaultNamedXContents());
            XContentParser parser = 
                JsonXContent.jsonXContent.createParser(registry, jsonResponse);
            return SearchResponse.fromXContent(parser);
        }catch (IOException e) {
            System.out.println("exception " + e);
        }catch (Exception e){
            System.out.println("exception " + e);
        }
    return new SearchResponse();
}