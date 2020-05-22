class Room {

    Room outerRoom;
    Room[] innerRooms;

    // creates a room with n inner rooms 
    Room (Room outerRoom, int n) {
        this.outerRoom = outerRoom;
        this.innerRooms = new Room[0];
    }

    // sets nth room to innerRoom
    void addRoom(int n, Room innerRoom) {
        innerRooms[n] = innerRoom;
    }

    // goes to nth room
    Room getRoom(int n) {
        return innerRooms[n];
    }

}