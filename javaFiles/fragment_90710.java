public class Entity
{
   private final static Map<Class<? extends Entity>, Set<String>> attributes = new HashMap<Class<? extends Entity>, Set<String>>();

   public static void populateAttributes(Class<? extends Entity> derivedClass)
   {
      //initialize the set of attributes for the derived class and 
      //add it to attributes map with "derivedClass" as key
   }

   static
   {
      populateAttributes(Entity.class);
   }

   public Entity()
   {
      //calling this.getClass() returns the object's actual (derived) class(*)
      if(!attributes.containsKey(this.getClass())
         populateAttributes(this.getClass());
   }

   //rest of class definition (including getAttributes method)
}

public class Customer extends Entity 
{
   @Attribute
   String someAttribute; //will be processed automatically
}