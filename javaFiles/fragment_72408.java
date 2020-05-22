public class Employee {

   private int id;
   // Default implementation might want to use "name" for as part of hashCode
   private String name; 

   @Override
   public int hashCode() {
     // We know that ID is always unique, so don't use name in calculating 
     // the hash code.
     return id;
   }
}