document.goToLocation = function goToLocation(searchString) {
    document.geocoder.geocode( {'address': searchString}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
        document.map.setCenter(results[0].geometry.location);
      } else {
        alert("Geocode was not successful for the following reason: " + status);
      }
    });
}