Unit<Area> sq_mile = USCustomary.MILE.multiply(USCustomary.MILE).asType(Area.class);
Unit<Area> sq_km = MetricPrefix.KILO(SI.METRE).multiply(MetricPrefix.KILO(SI.METRE)).asType(Area.class);

javax.measure.Quantity<Area> a = me.calcArea(polygon);
System.out.println(a);
System.out.println(a.to(sq_km));
System.out.println(a.to(sq_mile));