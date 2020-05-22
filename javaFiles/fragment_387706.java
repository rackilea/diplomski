void printRooms() {
    for (int i = 0; i < rooms.length; i++) {
        rooms[i].roomNr = "" + (i + 1);
        rooms[i].name = room.guests[0].getName();
    }
}