private void showJSON(String json){
    DriverLocation pj = new DriverLocation(json); // This does something with 
    pj.parJson(); // This builds some static arrays

    // This loops over an array
    for (int i=0;i<=DriverLocation.driverName.length;i++){
        String name = DriverLocation.driverName[i]; // Gets value
    }