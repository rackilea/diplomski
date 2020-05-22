public class Room
{
    private int roomNum;

    //I'm guessing what your constructor looks like based on your code, but I don't know the types
    public Room(boolean hasBed, String roomName, boolean isAccessible, boolean hasCoffee, int roomNumber)
    {
        roomNum = roomNumber;
    }

    //Here is your accessor method
    public int getRoomNumber()
    {
        return roomNum;
    }
}