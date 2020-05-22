String[] strs = new String[]; //Your string array, initialized elsewhere
Object[] os = new Object[];   //The objects that you want mapped.
Map<String, Object> m = new HashMap<String, Object>(); // I use HashMap because it is the most generic

for(int i = 0; i < strs.length; i++) {
  m.put(strs[i], os[i]); //Add each object, os[i], to the map at position str[i]
}