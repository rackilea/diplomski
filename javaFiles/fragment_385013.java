public void showMarker() {
    new Thread(new Runnable() {
        int width = 50;
        int height = 50;
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.drawable.car);
        Bitmap b = bitmapDrawable.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);

        @Override
        public void run() {
            final Gson gson = new Gson();
            final StringBuilder stringBuilder = new StringBuilder();
            final PaginatedList<VehicleLocationsDO> onTrackVehicles = dynamoDBMapper.scan(VehicleLocationsDO.class, new DynamoDBScanExpression());
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (onTrackVehicles.isEmpty())
                            Toast.makeText(getApplicationContext(), "No Vehicle on Track at present", Toast.LENGTH_SHORT).show();
                        else {
                            for (int i = 0; i < onTrackVehicles.size(); i++) {
                                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                                for (Marker m : markerList) {
                                    builder.include(m.getPosition());
                                }
                                LatLngBounds bounds = builder.build();
                                int padding = 70; // offset from edges of the map in pixels
                                CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
                                mMap.animateCamera(cu);
                                if (markerList.isEmpty()) {
                                    String OnTrackVehiclesString = gson.toJson(onTrackVehicles.get(i));
                                    stringBuilder.append(OnTrackVehiclesString + "\n");
                                    JsonModel onTrackVehiclesObject = gson.fromJson(OnTrackVehiclesString, JsonModel.class);
                                    int fetchedVehicleId = onTrackVehiclesObject.get_vehicleId();
                                    double fetchedLatitude = onTrackVehiclesObject.get_latitude();
                                    double fetchedLongitude = onTrackVehiclesObject.get_longitude();
                                    LatLng latLng = new LatLng(fetchedLatitude, fetchedLongitude);
                                    marker = mMap.addMarker(new MarkerOptions()
                                            .anchor(.5f,.5f)
                                            .position(latLng)
                                            .title("Vehicle No. "
                                            + String.valueOf(fetchedVehicleId))
                                            .icon(BitmapDescriptorFactory
                                            .fromBitmap(smallMarker)));
                                    marker.setTag(fetchedVehicleId);
                                    markerList.add(marker);
                                } else {
                                    for (final Marker m : markerList) {
                                        String OnTrackVehiclesString = gson.toJson(onTrackVehicles.get(i));
                                        stringBuilder.append(OnTrackVehiclesString + "\n");
                                        JsonModel onTrackVehiclesObject = gson.fromJson(OnTrackVehiclesString, JsonModel.class);
                                        final int fetchedVehicleId = onTrackVehiclesObject.get_vehicleId();
                                        double fetchedLatitude = onTrackVehiclesObject.get_latitude();
                                        double fetchedLongitude = onTrackVehiclesObject.get_longitude();
                                        LatLng latLng2 = new LatLng(fetchedLatitude, fetchedLongitude);
                                        int markerTag = (int) m.getTag();
                                        if (m.getTag() != null) {
                                            if (markerTag == fetchedVehicleId) {
                                                new Thread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        final VehicleLocationsDO readNewLocation = dynamoDBMapper.load(VehicleLocationsDO.class, fetchedVehicleId);
                                                        final LatLng updatedLatLng = new LatLng(readNewLocation.getLatitude(), readNewLocation.getLongitude());
                                                        runOnUiThread(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                double bearing = bearingBetweenLocations(m.getPosition(), updatedLatLng);
                                                                rotateMarker(m, (float) bearing);
                                                                MarkerAnimation.animateMarkerToGB(m, updatedLatLng, new LatLngInterpolator.Spherical());
                                                            }
                                                        });
                                                    }
                                                }).start();
                                            }
                                        } else {
                                            marker = mMap.addMarker(new MarkerOptions()
                                                    .position(latLng2)
                                                    .title(String.valueOf(fetchedVehicleId))
                                                    .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
                                            marker.setTag(fetchedVehicleId);
                                            markerList.add(marker);
                                        }
                                    }
                                }

                            }
                        }
                    } catch (Exception e) {
                        Log.e("Exception caught", e.toString() + "  " + e.getMessage() + "  " + e.getCause());
                    }
                }
            });
        }
    }).start();
}