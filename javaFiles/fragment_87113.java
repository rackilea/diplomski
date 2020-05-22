int compare(Item o1, Item o2) {
   if (o1.isBig && !o2.isBig)
     return -1;
   if (!o1.isBig && o2.isBig)
     return 1;
   if (o1.timestamp < o2.timestamp)
     return -1;
   if (o1.timestamp > o2.timestamp)
     return 1;
   return 0;
 }