HashMap<String, ArrayList<String>> vehicles = new HashMap<String, ArrayList<String>>();
ArrayList<String> makes = new ArrayList<String>();
makes.add("accord");
makes.add("civic");
vehicles.put("car", makes);
makes.clear();

makes.add("landcruzer");
makes.add("rangerover");
vehicles.put("suv", makes);
makes.clear();

makes.add("innova");
vehicles.put("muv", makes);
makes.clear();