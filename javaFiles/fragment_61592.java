public HashMap getDuplicateValues(HashMap in)
{
   // Clone input HashMap because we're removing stuff from it
   in = (HashMap)in.clone();
   HashMap rval = new HashMap();
   Object[] keys = in.keySet().toArray();

   // iterate through all keys
   for(int x=0;x<keys.length;x++) {
      Object value = in.get(keys[x]);
      in.remove(keys[x]);
      // if value is in input HashMap, store it in duplicate HashMap because it has another value
      if(in.containsValue(value)) {
         rval.put(keys[x],value);
      }
      // if value is in duplicate HashMap, store it also because it HAD another value earlier
      if(rval.containsValue(value)) {
         rval.put(keys[x],value);
      }
   }

   return(rval);
}