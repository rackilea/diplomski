String comma=",";
for (int i = 0; i < ziffern.length(); i++) {
      if (i == ziffern.length()-1) {
         comma="";
       }
       System.out.print(ziffern.charAt(i) + comma);
 }