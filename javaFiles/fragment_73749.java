LatLng center = new LatLng(40.384213, -3.875244);
List<LatLng> positions = new ArrayList<>();
positions.add(new LatLng(43.153102, 2.914307));
positions.add(new LatLng(42.976521, 1.508057));
positions.add(new LatLng(42.492353, 0.123779));

Display display = getActivity().getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width  = size.x;
                int height = size.y;

LatLngBounds bounds = findBounds(positions,center);
mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds,width,height,10));