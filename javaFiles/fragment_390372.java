public class Manager extends Residence {
   public Manager() {
      super();
  }

  public Manager(String p, String u, String pas, String acc, String type,    String no) {
      super(p , u , pas, acc, type , no);
  }

  public String getUsername() {
      return username;
  }
}