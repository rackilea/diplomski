LatLngBounds.Builder builder = new LatLngBounds.Builder();
builder.include(new LatLng(24.790874, 46.860488));
builder.include(new LatLng(24.828583, 46.842389));
builder.include(new LatLng(24.856611, 46.86747));
builder.include(new LatLng(24.837425, 46.895313));
LatLngBounds bounds = builder.build();

LatLng center = bounds.getCenter();