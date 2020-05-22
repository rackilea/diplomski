public class InventoryTrackerInterface
{
    public Inventory inv;

    public static void main(String args[])
    {
         // Test items
         Item b2 = new Item("abc",1,123,"01345");
         Item c2 = new Item("dfe",2,456,"56789");

         InventoryTrackerInterface instance = new InventoryTrackerInterface();

         // Inventory object
         instance.inv = new Inventory();

         instance.inv.addItem(b2);
         instance.inv.addItem(c2);

     }
}