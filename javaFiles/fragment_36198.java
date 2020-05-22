public void addPassenger(Man m) {
  if(passengers.size() >= get_capacity()) {
    throw new Exception("There cannot be more passengers than allowed");
  }
  passengers.add(m);
}