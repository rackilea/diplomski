private void processValues(Vehicle vehicle, String inputValue) {
  Command command;
  if ("Left".equals(inputValue)) {
    command = v -> v.turnLeft();  // <- With lambda expresion
  } else {
    command = Vehicle::turnRight; // <- With method reference
  }
  command.execute(vehicle);
}