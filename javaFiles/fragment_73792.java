LatLngBounds.Builder builder = new LatLngBounds.Builder();
for each (Marker m : markers) {
    builder.include(m.getPosition());
}

LatLngBounds bounds = builder.build();