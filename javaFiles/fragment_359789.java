class House{
  private long houseId;
  private List<Room> rooms;
  private Address address;
}

class Room{
  private int roomId;
  private House house;
}

class Address{
  private long addressId;
  ...
}