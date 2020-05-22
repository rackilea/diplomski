private int nrVehicles;
private Vehicle [] vehicles;

public Lot (  )
{
    nrVehicles = 0;
    vehicles = new Vehicle[MAX_VEHICLES];
}

public void park ( Vehicle v ) { 
    vehicles[ nrVehicles++ ] = v; 
}