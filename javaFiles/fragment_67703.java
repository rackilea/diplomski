Map<Integer, Double[]> dataMap = new HashMap<Integer, Double[]>();
dataMap.put(1, new Double[]{100,100});
// Other stuff...

// Replace value in map with a reference to a different array.
Double[] dob = new Double[] { 100, 200 };
dataMap.put(1, dob);