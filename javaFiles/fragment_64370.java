public void playdk1 (View view) 
if (dk1.isPlaying() == true) {
     dk1.stop();   
   }
 else{
    dk2.start();
    dk2.setLooping(true);}

if (dk2.isPlaying() == true) {
  dk2.stop();
} else {
dk1.start();
dk1.setLooping(true);
}
}

 public void playdk2 (View view) {
 if (dk2.isPlaying() == true) {
     dk2.stop();

     }
      else {
          dk1.start();
          dk1.setLooping(true);
        }

     if (dk1.isPlaying() == true) {
       dk1.stop();
       } else {
          dk2.start();
          dk2.setLooping(true);
        }
         }