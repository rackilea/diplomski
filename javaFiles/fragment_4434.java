Object[] location1 = new Object[] { 100, "Location1" };
Object[] location2 = new Object[] { 200, "Location2" };
Object[] location3 = new Object[] { 300, "Location3" };

List<Object[]> xAxisLocations = new ArrayList<>();
xAxisLocations.add(location1);
xAxisLocations.add(location2);
xAxisLocations.add(location3);

XAxisData xaxis = new XAxisData(xAxisLocations);

Map<String, XAxisData> xAxisData = new HashMap<String, XAxisData>();
xAxisData.put("xaxis", xaxis);