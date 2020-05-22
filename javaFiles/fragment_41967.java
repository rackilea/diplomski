public class Example {

    public static void main(String[] args) {
        ItemStore store;
        Monitor monitor;
        Mouse mouse;

        store = new ItemStore();
        monitor = new Monitor();
        monitor.id = 2;
        monitor.price = 6;

        mouse = new Mouse();
        mouse.id = 7;
        mouse.buttons = 3;

        store.addItem(monitor);
        store.addItem(mouse);

        System.out.println(store.getItem(2).price);   // = 6
        System.out.println(((Monitor) store.getItem(2)).dpi);
        System.out.println(((Mouse) store.getItem(7)).buttons); //Downcasting ... = 3
    }
    public static class Item {
       String id;
       String description;
       int price;
       // common attributes here!
    }

    public static class Monitor extends Item {
        private int dpi;
       // monitor particular atributes here!!
    }

    public static class Mouse extends Item {
        private int buttons;
        // mouse particular attributes here!!!
    }


    public static class ItemStore {
       private Hashtable<String, Item> table = new HashTable<>();

       public boolean addItem(Item item) {
           this.table.put(item.getId(), item);
       }

       public Item getItem(String id) {
           return this.table.get(id);
       }
    }
}