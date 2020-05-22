AddButton.setOnAction(e -> 
{  
 Vehicule vehicule = new Vehicule();  
 vehicle.setVehicleId(VehicleID.getText());
 vehicle.setVehicleName(VehicleNameF.getText());
 Vehicules.add(vehicule);
 //Vehicules is the array where you put all your objects.
})