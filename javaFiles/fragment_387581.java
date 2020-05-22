public class Customer implements User {
     private final RawDataView data;
     public CustomerView(UserView source) {
         this.data = source.getView(RawDataView.class);
     }

     // All User views must specify this
     @Override
     public long id() {
         return data.getId();
     }

     @Override
     public <T extends UserView> T getView(Class<T> view) {
         // construct or look up view
     }

     @Override
     public Json toJson() {
         return data.toJson();
     }


     //
     // Specific to Customer
     //
     public List<Item> shoppingCart() {
         List<Item> items = (List<Item>) data.getValue("items", List.class); 
     }

     // etc....
 }