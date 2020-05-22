Iterator it = map.entrySet().iterator();
   while (it.hasNext())
   {
      Entry item = it.next();
      it.remove();
   }