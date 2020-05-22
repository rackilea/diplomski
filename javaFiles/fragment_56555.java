int first = str.indexOf(".");
   if (first>-1){
        second = str.indexOf(".", first + 1);
   }
   if (second>-1){
       str=str.substring(0, second);
   }