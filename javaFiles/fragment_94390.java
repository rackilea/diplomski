public class GsonApp {

    private static final String TEST_JSON = "{\n" +
            "  \"data\": \"some data\",\n" +
            "  \"social\": {\n" +
            "    \"twitter\": \"id\"\n" +
            "  }\n" +
            "}";


    public static void main(String[] args) throws Exception {
        final Gson gson = new GsonBuilder().create();
        // Read Example
        final SocialLinks socialLinks = gson.fromJson(TEST_JSON, SocialLinks.class);
        System.out.println(gson.toJson(socialLinks));

        // Write with null Social 
        final SocialLinks socialLinks1 = new SocialLinks();
        socialLinks1.setData("MyData");
        System.out.println(gson.toJson(socialLinks1));

        // Write with empty Social (social.twitter is null)    
        final SocialLinks socialLinks2 = new SocialLinks();
        socialLinks2.setData("MyData");
        socialLinks2.setSocial(new Social());
        System.out.println(gson.toJson(socialLinks2));

        // Write with full Social
        final SocialLinks socialLinks3 = new SocialLinks();
        socialLinks3.setData("MyData");
        socialLinks3.setSocial(new Social());
        socialLinks3.getSocial().setTwitter("ID");
        System.out.println(gson.toJson(socialLinks3));
    }
}