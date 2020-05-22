LocationRequest request = new LocationRequest();
            request.setInterval(10000);
            request.setFastestInterval(5000);
            request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
            FusedLocationProviderClient client = 
         LocationServices.getFusedLocationProviderClient(this);
            int permission = ContextCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION);   
            if (permission == PackageManager.PERMISSION_GRANTED) {   
                    // Request location updates and when an update is 
                    // received, update text view    
                    client.requestLocationUpdates(request, new LocationCallback() {         
                            @Override  
                        public void onLocationResult(LocationResult locationResult) {                           
                            Location location = locationResult.getLastLocation();  
                            if (location != null) {   
                                    // Use the location object to get Latitute and Longitude and then update your text view.  
                            }  
                        }  
                    }, null);  
                }