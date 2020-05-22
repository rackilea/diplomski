public class Blog {
    String success;
    List<Result> results;
    public List<Result> getResults() {
        return results;
    }
}

public class Result {
   String type;
   public String getType() {
       return type;
   }
   List<Post> posts;
   public List<Post> getPosts() {
        return posts;
   }
}

public class Post {
   String music;
   public String getMusic() {
       return music;
   }
}