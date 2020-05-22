for(int pin=0; pin<pins.size(); pin++)
            {
                LatLng pinLocation = new LatLng(Float.parseFloat(pins.get(pin).latitude), Float.parseFloat(pins.get(pin).longitude));
                Marker storeMarker = map.addMarker(new MarkerOptions()
                .position(pinLocation)
                .title(pins.get(pin).pinname)
                .snippet(pins.get(pin).address)
                );
            }