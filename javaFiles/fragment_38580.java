public abstract class Room
{
    private String roomID;
    private boolean ensuite;
    private String guest;
    private String nights;
    private String booked;

    public Room (String roomID, boolean ensuite)
    {
       this.roomID = roomID;
       this.ensuite = ensuite;
       //so on...
    }
}