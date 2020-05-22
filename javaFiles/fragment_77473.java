public class ShopOwner {
   String owner;
   List<Shop> shops = new ArrayList<>(); // Shops owned by this ShopOwner.
   int age;     
   String dateOfBirth;
   public void addShop(Shop s) {
       // Note that this does NOT guarantee uniqueness of shops if your DB query returns multiple instances of the same shop.
       // If you want this, you could use a Map instead.
       this.shops.add(s);
   }
   // Your other getters etc.
}