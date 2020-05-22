List<Element> result = ...

for (List<Element> l : map.values()) {
   if ( l.size() > 1 ) {
       final Iterator i = l.iterator();
       Element head = i.next();
       while (i.hasNext()) {
          Element cur = i.next();
          if (comparator.compare(head,cur) == 0) {
             i.remove();
          }
          head = cur;
       }
   }
   result.addAll(l);
 }
 return result.toArray(..);