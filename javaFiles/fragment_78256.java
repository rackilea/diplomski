List<Vehicle> vehicleList = new ArrayList<>;
for(String s : vehicleNamesArray)
{
    newVehicle = new Vehicle(s);
    vehicleList.add(newVehicle);
  //I defined this Vehicle newVehicle = null; in the main class. My main is also in the same Vehicle.java file.
}