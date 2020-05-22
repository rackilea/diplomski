public void initialListCreation() {
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
                        for (int i = 0; i < onTrackVehicles.size(); i++) {
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
                                    +String.valueOf(fetchedVehicleId))
                                    .icon(BitmapDescriptorFactory.fromBitmap(smallMarker)));
                            marker.setTag(fetchedVehicleId);
                            markerList.add(marker);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }).start();
}