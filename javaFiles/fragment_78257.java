for (int i=0; i< vehicleNamesArray.size(); i++)
{
    if (vehicleNamesArray.get(i).matches(userVehicleName))
        //userVehicleName is the [0] vehicle name entered by user
        //userVehicleCommand is the [1] command entered by user
    {
        switch (userVehicleCommand.toLowerCase()) 
            {
               case "power on":

               vehicleList.get(i).powerOn(); //calling that particular bahaviour of the object defined in Vehicle class.
               System.out.println(vehicleList.get(i).getName()+" is powered ON.");
               break;
 ...
 ...