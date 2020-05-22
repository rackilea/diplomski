for (i=string.start;i<string.end-4;i++) {
   check=string.substring(i,4);
   c1=check.substring(0,1);
   c2=check.substring(1,1);
   c3=check.substring(2,1);
   c4=check.substring(3,1);
   if (c1.ansival==c2.ansival+1 && c2.ansival==c3.ansival+1 && c3.ansival==c4.ansival+1) {
      return false;
   } else {
      return true;
   }
}