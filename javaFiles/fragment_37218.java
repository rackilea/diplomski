public static void main(String[] args) {

    // ... (same as ... above)

    for (House house : houses) {
        Room room = rooms.get(house.getCode());

        room.setName(house.getName());
        room.setSize(house.getSize());

        // ... any other settings
    }
}