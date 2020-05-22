@Root
public class Citation{

   @ElementList
   private List<Part> list;

   @Attribute
   private String type;

   public String getType() {
      return type;
   }

   public List<Part> getList() {
      return list;
   }
}