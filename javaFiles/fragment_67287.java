public class InventoryTrackerInterface
{
    public static Inventory inv;

    public static void main(String args[])
    {
         // Test items
         Item b2 = new Item("abc",1,123,"01345");
         Item c2 = new Item("dfe",2,456,"56789");

         // Inventory object
         inv = new Inventory();

         inv.addItem(b2);
         inv.addItem(c2);

     }
}