public class Container<T extends Container> {
   protected List<T> elements = new ArrayList<T>();

   public List<T> getElements() {
       return elements;  
   }
}