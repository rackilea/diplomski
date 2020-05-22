Point[] p = [new Point(x1,y1), new Point(x2,y2),...];
List<Point[]> closePoints = new ArrayList<Point[]>();

for (int i=0; i<p.length-1; i++) {
  for (int j=i+1; j<p.length; j++) {
    if (Haversine.distance(p[i].latitude, p[i].longitude, p[j].latitude, p[j].longitude) < 5) {
      //Elements are inserted into the list as two-element arrays
      Point[] toAdd = {p[i], p[j]};
      closePoints.add(toAdd);
    }
  }
}
System.out.println(closePoints.get(0)[0].latitude); //access example