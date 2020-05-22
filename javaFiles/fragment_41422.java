Map<String,Integer> map = new HashMap<String,Integer>();

for ( String cityAndName : input ) { 
   String city = // split and get city
   String name = // split and get name
   Integer noOfEncounters = 0;
   if ( map.containsKey(city+"_"+name) ) { 
        noOfEncounters = map.get(city+"_"+name);
        noOfEncounters++;
   }
   map.put(city+"_"+name,noOfEncounters);
}