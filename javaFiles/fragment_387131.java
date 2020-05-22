public void newRoom(List<Room> roomList) {
    System.out.println("Please enter a name for your room");
    String name = scan.nextLine();
    Room aRoom = new Room(name);
    roomList.add(aRoom);
    System.out.println("You have added the " + name + ".");
    options();
}