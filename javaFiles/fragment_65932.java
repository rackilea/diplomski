public class AbcSupplier implements Supplier<List<Message>> {

     List<Message> list = new ArrayList<>();
     public AbcSupplier() {
         ......
         Some operations on list
         ......
     }

     public List<Message> get() {
         return list;
     }
}