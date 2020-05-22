String strUrl = "http://maps.googleapis.com/maps/api/distancematrix/json?origins=" 
                  + Double.toString(my_lat) + "," 
                  + Double.toString(my_lang) 
                  + "&destinations="+ Double.toString(lat) + "," 
                  + Double.toString(lang) 
                  + "&mode=walking&sensor=false";

// Line to check if url code is right
Log.d("APP", "strUrl = " + strUrl);