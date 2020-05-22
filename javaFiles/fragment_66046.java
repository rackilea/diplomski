if(gps_loc!=null){
    locationResult.gotLocation(gps_loc);
    return;
}

if(net_loc!=null){
    locationResult.gotLocation(net_loc);
    return;
}

locationResult.gotLocation(null);