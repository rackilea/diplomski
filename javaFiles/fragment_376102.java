public class AccountData {
   public String uname;
   public String uid;
   public String category;
   public String description;
   public Account account;



   public static class Account {
      public List<Double> entry;
      public List<Double> exit;
      public List<List<Double>> details;
      public List<Section> section;
   }

   public static class Section {
      public List<List<Double>> account;
      public String category;
      public String description;
      public String sectionname;
      public String id;
   }

}