public void park ( Vehicle v ) { 
    if(nrVehicles < MAX_VEHICLES) {
      vehicles[nrVehicles++] = v; 
    } else {
      throw new IllegalStateException("Lot full, go find another one!");
    }
}