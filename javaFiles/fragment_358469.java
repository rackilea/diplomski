class Room {

     // room properties
     int x, y, z;

     // constructor taking properties
     public Room (int x, int y, int z) {
         this.x = x;
         this.y = y;
         this.z = z;
     }

     // factory methods
     public static Room createRoomType1() {
         return new Room(100, 200, 300);
     }

     public static Room createRoomType2() {
         return new Room(400, 500, 600);
     }

}