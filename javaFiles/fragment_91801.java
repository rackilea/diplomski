class Room {

    Room outerRoom;
    Room innerRoom;

    Room(Room outerRoom, Room innerRoom) {
        this.outerRoom = outerRoom;
        this.innerRoom = innerRoom;
    }

    // goes to outerRoom
    Room exit() {
        return outerRoom;
    }

    // goes to innerRoom
    Room enter() {
        return innerRoom;
    }

}