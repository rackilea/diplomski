Map<DomainObject, Boolean> m = new HashMap<DomainObject, Boolean>();
   DomainObject do = new DomainObject(); 
   do.name = "ABC";
   m.put(do, true); // do goes in the map with hashCode of ABC
   do.name = "DEF";
   m.get(do);