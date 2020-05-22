Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
             runOnUiThread(new Runnable() 
             {
              public void run() 
              {  
                //update ui
                if (mapObj.isLocationClientConnected)
                    Location currentLocation = mapObj.gotoCurrentLocation();

              }
             });
           }
        }, 0, refreshUserLocationInterval);