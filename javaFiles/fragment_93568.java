//Create the map with the values
HashMap<String, String> solvents = new HashMap<String, String>();

//Populate the data in your map
solvents.put("CDCl3", "7.26");
solvents.put("H2O", "4.79");

//Obtain the shift value, null if the element wasn't found
String shiftvalue = solvents.get(chosen);