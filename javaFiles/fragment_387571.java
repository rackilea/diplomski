while (iter.hasNext()) {
     print(iter.next);
     if (iter.hasNext())
       print(',');
     else
       print('.');
   }