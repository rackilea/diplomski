/** copy constructor */
public Room(Room oldRoom) { 
   this(); // regular constructor
   this.room = oldRoom.room.clone(); // new Room gets its own array!
   this.roomType = oldRoom.roomType;
   // … etc for any other member variables
}