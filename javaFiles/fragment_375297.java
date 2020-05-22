public class Main {
  List<Plane> allPlanes; // Load in the omitted code somewhere else

  public int getAllPassengers()
  {
    int passengers = 0;
    for(Plane plane : allPlanes) // note the change
    {
        passengers += plane.getPassengerNumber();
    }
    return passengers;
  }
}