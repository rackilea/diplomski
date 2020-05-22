public interface Path {
   List<Item> getItems();
}

public class CurvePath implements Path {
   public List<Item> getItems() {
      //specific implementation for curved path, maybe
      return items;
   }
}

public class LinearPath implements Path {
   public List<Item> getItems() {
      //specific implementation for linear path
      return items;
   }
}


//...
void method(Path clazz) {

    ArrayList<Item> al = clazz.getItems();

}