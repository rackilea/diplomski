public final static int KITCHEN_ROOM = R.array.kitchen;
public final static int BATHROOM_ROOM = R.array.bathroom;

public String result(int room, int i)
{
    String[] roomItems =  roomID = getResources().getStringArray(room);
    // [room] + "_" + String.valueOf(item);

    if (rooms_items.length > i) return roomItems[i];

    // Here, you can throw an exception or return null;
    return null;
}