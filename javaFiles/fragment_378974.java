...
LatLng polylineStartLatLng = polyline.getPoints().get(0);

Drawable starDrawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.star_red_28px);
Canvas canvas = new Canvas();
Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
canvas.setBitmap(bitmap);
starDrawable.setBounds(0, 0, 28, 28);
starDrawable.draw(canvas);
BitmapDescriptor markerIcon = BitmapDescriptorFactory.fromBitmap(bitmap);
mGoogleMap.addMarker(new MarkerOptions()
        .position(polylineStartLatLng)
        .anchor(0.5f, 0.5f)
        .icon(markerIcon)
);
...