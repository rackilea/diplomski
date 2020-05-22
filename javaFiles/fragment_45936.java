String geom = "MULTIPOLYGON (..."
byte[] bgeom = geom.getBytes();
WKT wkt = new WKT ();
JGeometry jgeom = wkt.toJGeometry(bgeom);
bgeom = wkt.fromJGeometry(jgeom);
System.out.println(new String(bgeom, "UTF-8"));