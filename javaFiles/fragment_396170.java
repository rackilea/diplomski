// Create a new list of vehicles
List<Vehicle> vehicleList = new ArrayList<>();
Statement stmt=con.createStatement();  
ResultSet rsVehicle=stmt.executeQuery("select * from vehicle");  
while(rsVehicle.next()) {  
    // Create a new vehicle for each record returned from the query
    Vehicle vehicle = new Vehicle();

    // Set to the vehicle each property taken from that record
    vehicle.setBrand(rsVehicle.getString(1));
    ...

    // Add that vehicle to the list
    vehicleList.add(vehicle);
}

...

// Iterate the list and print each field you need
for (Vehicle vehicle: vehicleList) {
   // PRint each vehicle
   System.out.println("Vechicle brand: " + vehicle.getBrand());
}