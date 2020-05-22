StringBuilder sb = new StringBuilder();
   for (/* lots of times */) {
       // do stuff
       sb.append(someOtherString);
   }
   String s = sb.toString();