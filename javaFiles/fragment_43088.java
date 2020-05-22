List<String> strings = Files.readAllLines(Paths.get("test.txt"));
List<Room> rooms = new ArrayList<>();

for (String line : strings) {
    String[] split = line.split(",");

    Integer roomNumber = Integer.valueOf(split[0]);
    String roomType = split[1];
    Double roomCost = Double.valueOf(split[2]);
    Integer amount = Integer.valueOf(split[3]);
    String bathroom = split[4];

    Room r = new Room(roomNumber, roomType, roomCost, amount, bathroom);
    rooms.add(r);
}