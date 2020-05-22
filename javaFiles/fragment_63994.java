@Override
 public void JsonArrayLoaded(AsyncTask<String, String, String> task,
                             JSONArray result) 
    {
         if(task instanceof GettingBeaconsList) { 
                //  do stuff related to the beacon list
         }

         else if(task instanceof GettingAirports) { 
            // do airport list stuff
         }

    }