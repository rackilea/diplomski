void printRooms() {
    for (int i = 0; i < rooms.length; i++) {
        rooms[i].roomNr = "" + (i + 1);
        for (int j = 0; j < 2; j++) {
            a = guest1.getName();
            //  ^^^^^^ Compiler error: cannot resolve symbol "guest1"
            rooms[i].name = a;
        }
    }
}