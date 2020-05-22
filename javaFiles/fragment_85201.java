@Controller
@RequestMapping("/test")
public class formCntrl {
    @RequestMapping(value = "/dbOperation", method = RequestMethod.POST)
    public @ResponseBody String (HttpServletResponse resp,
        @RequestParam("title") String title,
        @RequestParam("description") String description,
        @RequestParam("likes") int likes,
        @RequestParam("url") String url,
        @RequestParam("by") String by) {
            try{   
                // To connect to mongodb server
                MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
               // Now connect to your databases
               DB db = mongoClient.getDB( "cms" );
               System.out.println("Connect to database successfully");
               boolean auth = db.authenticate(myUserName, myPassword);
               System.out.println("Authentication: "+auth);         
               DBCollection school = db.getCollection("school");
               System.out.println("Collection mycol selected successfully");
               BasicDBObject doc = new BasicDBObject("title", title).
                   append("description", description).
                   append("likes", likes).
                   append("url", url).
                   append("by", by);
               school.insert(doc);
               System.out.println("Document inserted successfully");
             }catch(Exception e){
                 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
             }
    }
}