import java.util.*;

public class ItemRegister{

    public static void main(String []args){
        ItemRegister ir = new ItemRegister();
    }

    // storing items registered here
    private HashMap<String,Item> items;

    /**
     * Constructor for objects of class ItemRegister
     */
    public ItemRegister(){
        items = new HashMap<String,Item>();

        ArrayList<Room> roomList = new ArrayList<>();
        roomList.add( new Room( new Item("Item A") ) );
        roomList.add( new Room( new Item("Item B") ) );
        roomList.add( new Room( new Item("Item C") ) );
        roomList.add( new Room( new Item("Item D") ) );


        System.out.println( "Size of Registered Items:" + items.size() ); 

        // Register only A item
        Item aItem = new Item("Item A");
        register( roomList, aItem );

        /// print whatever is in the register
        System.out.println( "Size of Registered Items:" + items.size() ); 
        System.out.println( "Registered Items:" ); 

        for( Item item : items.values() ){
            System.out.println( item.getDescription() ); 
        }
        System.out.println( "---- end ----" ); 

        // Register B item too
        Item bItem = new Item("Item B");        
        register( roomList, bItem );

        /// print whatever is in the register
        System.out.println( "Size of Registered Items:" + items.size() ); 
        System.out.println( "Registered Items:" ); 

        for( Item item : items.values() ){
            System.out.println( item.getDescription() ); 
        }
        System.out.println( "---- end ----" ); 
    }

    /**
     * register items in hashMap
     */
    public void register(Item a){
        items.put(a.getDescription(), a);
        System.out.println( "Registered an Item" ); 
    }

    public void register(ArrayList<Room> roomList, Item a){
        Iterator i = roomList.iterator();

        while (i.hasNext()) {
            Room room = (Room)i.next();

            if (room.getItem() != null && room.getItem().equals(a)){
                register( room.getItem() );
            }
        }
    }

    /* class Item */
    protected class Item{
        private String description;

        Item(String description){
            this.description = description;
        }

        public String getDescription(){
            return this.description;
        }

        public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }

        Item item = (Item) o;

        if (!description.equals(item.description)) {
            return false;
        }

        return true;
    }
    }

    /* class Room */
    protected class Room{
        private Item item;

        Room( Item item ){
            this.item = item;
        }

        public Item getItem(){
            return this.item;
        }
    }
}