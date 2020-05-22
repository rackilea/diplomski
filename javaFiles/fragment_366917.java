int i = 0;
ArrayList<vehicle> vehicles = new ArrayList();
while (i < data.length)
{
  if (data[i].equalsIgnoreCase("vehicle"))
  {
    Vehicle vehicle = new Vehicle();
    vehicle.setOwner(data[++i]);
    ...
    vehicles.add(vehicle);
  }
  else if (data[i].equalsIgnoreCase("american car"))
  {
    ...
  }
  i++;
}