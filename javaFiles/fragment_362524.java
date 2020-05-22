for (int i=0;i< latlngs.size();i++) {
            LatLng point=latlngs.get(i);
            options.position(point);
            options.title(Names.get(i));
            options.snippet("someDesc");
            mMap.addMarker(options);
        }