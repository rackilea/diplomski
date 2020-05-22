HashMap<String, Integer> array1 = new HashMap<String, Integer>();
ArrayList<String> array2 = new ArrayList<String>();
array1.put("Avocados", 3);
array1.put("Tomatoes", 3);
//etc.
array1.keySet().containsAll(array2);