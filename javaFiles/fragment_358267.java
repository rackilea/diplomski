private <T extends IRoom> List<T> filterRoomByType(Class<T> roomType) {
    List<T> r = new ArrayList<>();
    for (IRoom room : rooms) {
        if (roomType.isInstance(room)) {
            r.add((T) room);
        }
    }
    return r;
}