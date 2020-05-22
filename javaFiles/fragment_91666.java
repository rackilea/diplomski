public class Center
{
   private List<Floor> floors;
   ...
   public List<Floor> getFloors()
   {

      return this.floors;
   }
}

public class Floor
{
   private List<Room> rooms
   ...
}

public class Room
{
   private String roomNumber;
   ...
}