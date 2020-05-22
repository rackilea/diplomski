public class Room
{
  // define constructor and anything else you need
  // such as whether this room was visited already

  // assign different directions from the room
  Room getExit( Direction dir )
  {
    return exits.get( dir );
  }

  void addExit( Direction dir, Room room )
  {
    exits.put( dir, room );
  }

  private Map<Direction,Room> exits = new HashMap<>();
}