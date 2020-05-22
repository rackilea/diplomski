final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
 boolean onOff = false;
 @Override
 public void run() {
     // imageId is set in the onLocationChanged based on 'progress'
     // determination - 0/8 complete; 1/8 complete...
     int currentImageId = imageId;

     // icons is an array list populated at initialization with 
     // BitmapDescriptors from resources - one for each progress
     // fraction (0 - 8).
     BitmapDescriptor currentIcon = icons.get(currentImageId);

     // Flashing results from using the "0-progress" indicator icon
     // which is at index 0.
     BitmapDescriptor offIcon = icons.get(0);

     if (onOff) {
         marker1.setIcon(offIcon);
     } else {
         marker1.setIcon(currentIcon);
     }
     onOff = !onOff;

     // restart handler timer.
     handler.postDelayed(this, 500);
 }
}, 100);