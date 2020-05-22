JSONObject mainObject = new JSONObject(); // Main Object.    
JSONArray categoryArray; // Category Array.    
JSONObject categoryObject; // Category Object.
JSONArray readingsMainArray; // An array of arrays.
JSONArray readingsChildArray; // A child array.
JSONObject readingsObject; // A readings entry.

// Create arrays.
readingsMainArray = new JSONArray();
readingsChildArray = new JSONArray();

// Create JSONObject.
readingsObject = new JSONObject();

// Put values.
readingsObject.put("Name":"SYS");
readingsObject.put("Type":"INT");
readingsObject.put("Value":"200");

// Add to the child array.
readingsChildArray.put(readingsObject);

// Repeat 3 times for the other values.

// Now add the readings child array to the main array.
readingsMainArray.put(readingsChildArray);

// Now the category JSONObject.
categoryObject = new JSONObject();

// Put values.
categoryObject.put("Category","BP);
categoryObject.put("CollectionTime","2015-12-28T09:09:22-05:00");
categoryObject.put("DeviceInfo",null);
categoryObject.put("Readings", readingsMainArray);

// Put the category object into the category array.
categoryArray = new JSONArray();
categoryArray.put(categoryObject);

// Repeat this process for the "second" category array.

// Add category array to the main object.
mainObject.put("PeripheralList",categoryArray);