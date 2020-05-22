public class Elements implements Serializable {
   private static final long serialVersionUID = ...

   @Attribute (name = "type", required = false)
   private String type;

   @ElementList (name = "elements", entry = "element", inline = true)
   private List<Element> elements;
}