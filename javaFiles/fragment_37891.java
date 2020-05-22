google.maps.event.addListener(marker, 'dragstart', function(event) {
    //increase size
    marker.setIcon({url : 'path_to_img', scaledSize: {height: 12 , width: 12}})
  });

  google.maps.event.addListener(marker, 'dragend', function(event) {
   //decrease size
   marker.setIcon({url : 'path_to_img', scaledSize: {height: 64 , width: 64}})
  });