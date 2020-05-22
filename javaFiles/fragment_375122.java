Vehicle vehicle = null; 
  for(Vehicle newVehicle : allVehicles) {
       if (newVehicle.isLarge()){
            if (vehicle == null) {
                 vehicle = newVehicle;
                 vehicle.setIndex(0);
            }else{
                 vehicle.addLargeVehicle(newVehicle));
            }
       } 
  } 

  Vehicle[] largeVehicles = Vehicle.largeVehiclesToArray();