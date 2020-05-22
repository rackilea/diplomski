Object o = concurrentMap.get(key);

if(o == null){
   Object ret = concurrentMap.putIfAbsent(key, value);
   if(ret == null){
      o = ret;
   }
}
return o;