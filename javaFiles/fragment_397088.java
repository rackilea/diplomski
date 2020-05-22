Audi audi = new Audi();
Vehicle vehicle = audi;
String audiSeries = audi.series; 
System.out.println("direct-audi: " + audiSeries);
String vehicleSeries = vehicle.series; 
System.out.println("direct-vehicle: " + vehicleSeries);


Class audiClass = Class.forName(Audi.class.getName());
Class vehicleClass = Class.forName(Vehicle.class.getName());


Object audiObj = audiClass.newInstance();
Field audiSeriesField = audiClass.getField("series");
Field vehicleSeriesField = vehicleClass.getField("series");

System.out.println("reflection-audi: " + audiSeriesField.get(audiObj));
System.out.println("reflection-vehicle: " +  vehicleSeriesField.get(audiObj));