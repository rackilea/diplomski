public boolean hasParkingSlot(String searching) {
  for(ParkingSlot slot : slots) {
    if(slot.getID().equals(searching)) return true;
  }
  return false;
}