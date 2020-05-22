public class Website {
   private String URL;

   public Website(){
      this.URL = "";
   }

   public void setUrl(String url) {
      this.URL = url;
   }

   public String getUrl() {
      return this.URL;
   }

  public long save() {
     return db.save(this.URL);
  }

}