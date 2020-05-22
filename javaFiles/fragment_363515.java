private final IntMap<Array<Item>> roomsToItems = new IntMap();
private Array<Item> items;

//...

public void loadItems(int roomNumber) {
    items = roomsToItems.get(roomNumber); //get this room's previous list if it exists
    if (items == null) { //this room hasn't been loaded yet
        items = new Array<>();

        //TODO: Load the items into "items"

        //store the items list so it can be retrieved instead of loaded next time:
        roomsToItems.put(roomNumber, items);
    }
}