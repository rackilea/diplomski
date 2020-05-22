@Override
public void onLocationChanged(Location location) {
    try {
          int a = 0;
          float dis = calcdist(location.getLatitude(),location.getLongitude,lat,lng);
          if(dis <= 30) {

             int a = a+1; //add 1 if you are in the circle

             if(a = 1) { //if a=1 it will do the rest
                     MediaPlayer mp = MediaPlayer.create(this,R.raw.sound);
                     mp.setLooping(false);
                     mp.start();
                 } else {
                     mp.stop();
                 }
           }

           //if you are not int he circle

           if(dis > 30) {
               int a = 0;
           }

       } catch (Exception e) {
        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
       }
  }