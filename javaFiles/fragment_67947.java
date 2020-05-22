public class YourClass {

    List<LatLong> points;

    public YourClass() {
        points = new ArrayList<>();
    }

    private void drawLines(LatLng latLng) {
       points.add(latLng);
       map.addPolyline(new PolylineOptions().addAll(points).
                width(5).color(Color.BLUE);
    }

}