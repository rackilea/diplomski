public class SampleAction {
   private String title;
 public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
   private String body;
 public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body= body;
        }
   private int userId;
 public String getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId= userId;
        }


    public int execute()
     {  
        try{
         actorSeqID = 3;
         System.out.println(data+"--");
        }catch(Exception e){
            e.printStackTrace();
        }


      return actorSeqID;
     }