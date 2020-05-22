public class Room {
   private int _roomNumber;

   public Room(int roomNumber) {
      _roomNumber = roomNumber;
   }

   public int getRoomNumber() {
      return _roomNumber;
   }
}

public class Robot {
   public void move(Room room) {
      int currentRoom = room.getRoomNumber();
   }
}