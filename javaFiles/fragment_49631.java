@XmlRootElement(name = "Item")
public class Item
{


   private String name;

   public String getName() 
   {
      return this.name;
   }

   @XmlAttribute(name = "Name" )
   public void setName( String name )
   {
       this.name = name;
   }

}